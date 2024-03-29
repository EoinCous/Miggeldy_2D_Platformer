import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.UnitTests;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * Created by Abraham Campbell on 15/01/2020.
 *   Copyright (c) 2020  Abraham Campbell

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
   
   (MIT LICENSE ) e.g do what you want with this :-) 
 */ 



public class MainWindow {
	 private static JFrame frame = new JFrame("Game");   // Change to the name of your game 
	 private static Model gameworld;
	 private static Viewer canvas;
	 private static KeyListener Controller =new Controller(); 
	 private static int TargetFPS = 100;
	 private static boolean startGame = false; 
	 private static JLabel BackgroundImageForStartMenu ;
	 private static JButton singlePlayerButton;
	 private static JButton multiplayerButton;
	 private static Clip clip;
	  
	public MainWindow() {
	    frame.setSize(613, 400); 
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //If exit // you can modify with your way of quitting , just is a template.
	    frame.setLayout(null); 
	    
		//Singleplayer       
        singlePlayerButton = new JButton("Single Player"); 
        singlePlayerButton.addActionListener(new ActionListener()
           { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				gameworld = new Model();
				canvas = new  Viewer(gameworld);
				frame.add(canvas); 
				canvas.setBounds(0, 0, 1000, 600); 
				canvas.setBackground(new Color(255,255,255));  
			    canvas.setVisible(false);   
				singlePlayerButton.setVisible(false);
				multiplayerButton.setVisible(false);
				BackgroundImageForStartMenu.setVisible(false); 
				frame.setSize(1000, 600);
				canvas.setVisible(true); 
				canvas.addKeyListener(Controller);    //adding the controller to the Canvas  
				canvas.requestFocusInWindow();   // making sure that the Canvas is in focus so keyboard input will be taking in .
				startGame=true;
				gameAudio();
				
			}});  
        int buttonWidth = 40;
        singlePlayerButton.setBounds(frame.getWidth()/2 - (buttonWidth*2), frame.getHeight()/4, 200, buttonWidth); 
        
        //Multiplayer
        multiplayerButton = new JButton("Multiplayer");  // start button 
        multiplayerButton.addActionListener(new ActionListener()
           { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				gameworld = new Model(true);
				canvas = new  Viewer(gameworld);
				frame.add(canvas); 
				canvas.setBounds(0, 0, 1000, 600); 
				canvas.setBackground(new Color(255,255,255));  
			    canvas.setVisible(false); 
			    singlePlayerButton.setVisible(false);
				multiplayerButton.setVisible(false);
				BackgroundImageForStartMenu.setVisible(false); 
				frame.setSize(1000, 600);
				canvas.setVisible(true); 
				canvas.addKeyListener(Controller);    //adding the controller to the Canvas  
				canvas.requestFocusInWindow();   // making sure that the Canvas is in focus so keyboard input will be taking in .
				startGame=true;
				gameAudio();
			}});  
        multiplayerButton.setBounds(frame.getWidth()/2 - (buttonWidth*2), frame.getHeight()/2, 200, buttonWidth); 
        
        //loading background image 
        File BackgroundToLoad = new File("res/Miggeldy_Menu.png");  //should work okay on OSX and Linux but check if you have issues depending your eclipse install or if your running this without an IDE 
		
        try {
			 BufferedImage myPicture = ImageIO.read(BackgroundToLoad);
			 ImageIcon imageIcon = new ImageIcon(myPicture);
			 BackgroundImageForStartMenu = new JLabel(imageIcon);
			 BackgroundImageForStartMenu.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			 frame.add(BackgroundImageForStartMenu);
			
		}  catch (IOException e) { 
			e.printStackTrace();
		}   
		
		frame.add(singlePlayerButton);  
		frame.add(multiplayerButton);
        frame.setVisible(true);   
	}

	public static void main(String[] args) {
		MainWindow hello = new MainWindow();  //sets up environment 
		
		while(true)   //not nice but remember we do just want to keep looping till the end.  // this could be replaced by a thread but again we want to keep things simple 
		{ 
			//swing has timer class to help us time this but I'm writing my own, you can of course use the timer, but I want to set FPS and display it 
			
			int TimeBetweenFrames =  1000 / TargetFPS;
			long FrameCheck = System.currentTimeMillis() + (long) TimeBetweenFrames; 
			
			//wait till next time step 
			while (FrameCheck > System.currentTimeMillis()){} 
			
			//if(startGame && !paused){
			if(startGame){
				gameloop();
			}
			
			//UNIT test to see if framerate matches 
			UnitTests.CheckFrameRate(System.currentTimeMillis(),FrameCheck, TargetFPS); 
		}	
	} 
	
	//Basic Model-View-Controller pattern 
	private static void gameloop() { 
		// GAMELOOP  
		
		
		// model update   
		gameworld.gamemode();
		
		// view update 
		canvas.updateview(); 
		
		// Both these calls could be setup as  a thread but we want to simplify the game logic for you.  
		//score update  
		frame.setTitle("Score =  "+ gameworld.getScore() + " Lives = " + gameworld.getLives()); 
		
		if(gameworld.getLives() < 1 || gameworld.getLevel() > 8) {
			startGame = false;
			endGame();
		}
	}
	
	private static void endGame() {
		startGame = false;
		clip.stop();
		gameOverAudio();
		JOptionPane.showMessageDialog(null, "Game Over! Your score was " + gameworld.getScore() + ".");
		
		gameworld.resetGame(); // reset the game world
		frame.setTitle("Game"); // reset the frame title
		frame.setSize(613, 400); 

		canvas.setVisible(false); // hide the canvas
		canvas.removeKeyListener(Controller); // remove the controller from the canvas
		BackgroundImageForStartMenu.setVisible(true); // show the background image for the start menu
		singlePlayerButton.setVisible(true); 
		multiplayerButton.setVisible(true);
	   
	}
	
	//How to use Clip https://www.baeldung.com/java-play-sound
	private static void gameAudio() {
		try {
		   File file = new File("audio/Grasslands_Theme.wav");
		   AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
		   clip = AudioSystem.getClip();
		   clip.open(audioIn);
		   clip.loop(Clip.LOOP_CONTINUOUSLY);
		   
		} catch (Exception e) {
			   e.printStackTrace();
		}
	}
	
	//How to use Clip https://www.baeldung.com/java-play-sound
	private static void gameOverAudio() {
		try {
		   File file = new File("audio/only_game.wav");
		   AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
		   Clip clip = AudioSystem.getClip();
		   clip.open(audioIn);
		   clip.start();
		} catch (Exception e) {
			   e.printStackTrace();
		}
	}

}

//Start menu image from https://www.facebook.com/MDPStudios/photos/a.362544013791999.82504.109986249047778/1194890970557295/?type=3&theater

//Theme song from https://opengameart.org/content/platformer-game-music-pack
//Game over audio from https://tuna.voicemod.net/search/sounds?search=platformer%20game


/*
 * 
 * 

Hand shake agreement 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,=+++
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,:::::,=+++????
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,:++++????+??
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,:,,:,:,,,,,,,,,,,,,,,,,,,,++++++?+++++????
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,=++?+++++++++++??????
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,~+++?+++?++?++++++++++?????
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:::,,,,,,,,,,,,,,,,,,,,,,,,,,,~+++++++++++++++????+++++++???????
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,,,,,,,,,,,,,,,,,,,:===+=++++++++++++++++++++?+++????????????????
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,~=~~~======++++++++++++++++++++++++++????????????????
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,::::,,,,,,=~.,,,,,,,+===~~~~~~====++++++++++++++++++++++++++++???????????????
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,,~~.~??++~.,~~~~~======~=======++++++++++++++++++++++++++????????????????II
:::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,:=+++??=====~~~~~~====================+++++++++++++++++++++?????????????????III
:::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,++~~~=+=~~~~~~==~~~::::~~==+++++++==++++++++++++++++++++++++++?????????????????IIIII
::::::::::::::::::::::::::::::::::::::::::::::::,:,,,:++++==+??+=======~~~~=~::~~===++=+??++++++++++++++++++++++++?????????????????I?IIIIIII
::::::::::::::::::::::::::::::::::::::::::::::::,,:+????+==??+++++?++====~~~~~:~~~++??+=+++++++++?++++++++++??+???????????????I?IIIIIIII7I77
::::::::::::::::::::::::::::::::::::::::::::,,,,+???????++?+?+++???7?++======~~+=====??+???++++++??+?+++???????????????????IIIIIIIIIIIIIII77
:::::::::::::::::::::::::::::::::::::::,,,,,,=??????IIII7???+?+II$Z77??+++?+=+++++=~==?++?+?++?????????????III?II?IIIIIIIIIIIIIIIIIIIIIIIIII
::::::::::::::::::::::::::::::,,,,,,~=======++++???III7$???+++++Z77ZDZI?????I?777I+~~+=7+?II??????????????IIIIIIIIIIIIIIIIIIIIII??=:,,,,,,,,
::::::::,:,:,,,,,,,:::~==+=++++++++++++=+=+++++++???I7$7I?+~~~I$I??++??I78DDDO$7?++==~I+7I7IIIIIIIIIIIIIIIIII777I?=:,,,,,,,,,,,,,,,,,,,,,,,,
++=++=++++++++++++++?+????+??????????+===+++++????I7$$ZZ$I+=~$7I???++++++===~~==7??++==7II?~,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
+++++++++++++?+++?++????????????IIIII?I+??I???????I7$ZOOZ7+=~7II?+++?II?I?+++=+=~~~7?++:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
+?+++++????????????????I?I??I??IIIIIIII???II7II??I77$ZO8ZZ?~~7I?+==++?O7II??+??+=====.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
?????????????III?II?????I?????IIIII???????II777IIII7$ZOO7?+~+7I?+=~~+???7NNN7II?+=+=++,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
????????????IIIIIIIIII?IIIIIIIIIIII????II?III7I7777$ZZOO7++=$77I???==+++????7ZDN87I??=~,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
IIII?II??IIIIIIIIIIIIIIIIIIIIIIIIIII???+??II7777II7$$OZZI?+$$$$77IIII?????????++=+.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII?+++?IIIII7777$$$$$$7$$$$7IIII7I$IIIIII???I+=,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII???????IIIIII77I7777$7$$$II????I??I7Z87IIII?=,,,,,,,,,,,:,,::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
777777777777777777777I7I777777777~,,,,,,,+77IIIIIIIIIII7II7$$$Z$?I????III???II?,,,,,,,,,,::,::::::::,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
777777777777$77777777777+::::::::::::::,,,,,,,=7IIIII78ZI?II78$7++D7?7O777II??:,,,:,,,::::::::::::::,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
$$$$$$$$$$$$$77=:,:::::::::::::::::::::::::::,,7II$,,8ZZI++$8ZZ?+=ZI==IIII,+7:,,,,:::::::::::::::::,:::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
$$$I~::::::::::::::::::::::::::::::::::::::::::II+,,,OOO7?$DOZII$I$I7=77?,,,,,,:::::::::::::::::::::,,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
::::::::::::::::::::::::::::::::::::::::::::::::::::::+ZZ?,$ZZ$77ZZ$?,,,,,::::::::::::::::::::::::::,::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::I$:::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,
                                                                                                                             GlassGiant.com
 * 
 * 
 */
