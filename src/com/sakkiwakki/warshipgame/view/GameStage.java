package com.sakkiwakki.warshipgame.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

import java.util.Arrays;
import java.util.Random;

import com.sakkiwakki.warshipgame.resource.NoteShipsStatsCalc;
import com.sakkiwakki.warshipgame.shipinfo.ShipNames;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;

abstract class GameStage extends Scene {
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	private AnchorPane mainPane;
	private ImageView shipImage;
	
	private boolean w;
	private boolean a;
	private boolean s;
	private boolean d;
	private boolean space;
	
	//Stats:
	Random rng2 = new Random();
	
	private int[] radiuses = {rng2.nextInt(10),rng2.nextInt(10),rng2.nextInt(10),rng2.nextInt(10),rng2.nextInt(10),rng2.nextInt(10),rng2.nextInt(10)};
	
	private int playerHealth = 100 + NoteShipsStatsCalc.calculateHEALTH();
	private int collisionDmg = 20;
	
	private NoteShipsStatsCalc bob = new NoteShipsStatsCalc();
	
	private int collisionRadius = 30 + NoteShipsStatsCalc.arrIntMode(radiuses) - NoteShipsStatsCalc.minNum(radiuses) + NoteShipsStatsCalc.maxNum(radiuses) + bob.getAnts()/2;
	//

	
	private AnimationTimer gameTimer;
	
	private static final String MASS_PRODUCED_DD_IMG = "/com/sakkiwakki/warshipgame/resource/image/ship/mass_produced_dd.png";
	private ImageView[] numberOfEnemy;
	Random rng;
	
	public GameStage() {
		super(new AnchorPane(), WIDTH, HEIGHT);
		SelectScreen.gameStart = true;
		mainPane = (AnchorPane) this.getRoot();
		
		rng = new Random();
		
		createEnemy();
		createBackground();
		createShip(SelectScreen.whichShip);
		createKeyListeners();
		createGameLoop();
		System.out.println(Arrays.toString(NoteShipsStatsCalc.eachDigitInInt(playerHealth)));
	}

	private void createKeyListeners() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.W) {
					w = true;
				}
					
				if (event.getCode() == KeyCode.A) {
					a = true;
				}
					
				if (event.getCode() == KeyCode.S) {
					s = true;
				}
					
				if (event.getCode() == KeyCode.D) {
					d = true;
				}	
			}
		});
		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.W) {
					w = false;
				}
					
				if (event.getCode() == KeyCode.A) {
					a = false;
				}
					
				if (event.getCode() == KeyCode.S) {
					s = false;
				}
					
				if (event.getCode() == KeyCode.D) {
					d = false;
				}	
			}
		});
	}
	
	private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override 
			public void handle(long now) {
				moveShip();
				moveEnemy();
				tooLeft();
				collision();
			}
		};
		gameTimer.start();
	}
	
	/*
	 * This method allows the user to move the ship using the WASD keys on the keyboard.
	 * 
	 * Precondition: StageOne has to be set as a scene of the main stage
	 * 
	 */
	
	private void moveShip() {
		if (!w && !d && !s && !a) {
			shipImage.setLayoutX(shipImage.getLayoutX());
			shipImage.setLayoutY(shipImage.getLayoutY());
		}
		if (w && !d && !s && !a) {
			shipImage.setLayoutY(shipImage.getLayoutY()-2);
		}
		if (!w && d && !s && !a) {
			shipImage.setLayoutX(shipImage.getLayoutX()+2);
		}
		if (!w && !d && s && !a) {
			shipImage.setLayoutY(shipImage.getLayoutY()+2);
		}
		if (!w && !d && !s && a) {
			shipImage.setLayoutX(shipImage.getLayoutX()-2);
		}
		if (w && d && !s && !a) {
			shipImage.setLayoutY(shipImage.getLayoutY()-2);
			shipImage.setLayoutX(shipImage.getLayoutX()+2);
		}
		if (!w && d && s && !a) {
			shipImage.setLayoutX(shipImage.getLayoutX()+2);
			shipImage.setLayoutY(shipImage.getLayoutY()+2);
		}
		if (!w && !d && s && a) {
			shipImage.setLayoutY(shipImage.getLayoutY()+2);
			shipImage.setLayoutX(shipImage.getLayoutX()-2);
		}
		if (w && !d && !s && a) {
			shipImage.setLayoutY(shipImage.getLayoutY()-2);
			shipImage.setLayoutX(shipImage.getLayoutX()-2);
		}
	}
	
	/*
	 *  This method creates the ship sprite for the gameplay
	 *  
	 *  @param  ship  the ship the player selected
	 *  
	 *  Precondition: The player has to have chosen the valid ship in the ship selection screen
	 * 	Postcondition: The sprite of the ship the player chose will be shown on screen
	 * 
	 */
	
	private void createShip(ShipNames ship) {
		shipImage = new ImageView(ship.getPicture());
		shipImage.setFitHeight(70);
		shipImage.setFitWidth(150); 
		shipImage.setPreserveRatio(true);
		shipImage.setLayoutX(90);
		shipImage.setLayoutY(HEIGHT/2);
		mainPane.getChildren().add(shipImage);
	}
	
	
	private void createEnemy() {
		numberOfEnemy = new ImageView[6];
		for (int i = 0; i < numberOfEnemy.length; i++) {
			numberOfEnemy[i] = new ImageView(MASS_PRODUCED_DD_IMG);
			numberOfEnemy[i].setFitHeight(70);
			numberOfEnemy[i].setFitWidth(150); 
			numberOfEnemy[i].setPreserveRatio(true);
			setPosition(numberOfEnemy[i]);
			mainPane.getChildren().add(numberOfEnemy[i]);
		}
	}
	
	private void moveEnemy() {
		for (int i = 0; i < numberOfEnemy.length; i++) {
			numberOfEnemy[i].setLayoutX(numberOfEnemy[i].getLayoutX()-2);
		}
	}
	
	private void tooLeft() {
		for (int i = 0; i < numberOfEnemy.length; i++) {
			if (numberOfEnemy[i].getLayoutX() < -200) {
				setPosition(numberOfEnemy[i]);
			}
		}
	}
	
	private void setPosition(ImageView img) {
		img.setLayoutX(rng.nextInt(2000)+800);
		img.setLayoutY(rng.nextInt(400)+100);
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("com/sakkiwakki/warshipgame/resource/image/background/background.png", 850, 600, true, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	/**
	 * This decreases the int playerHealth by the int collisionDmg
	 * 
	 * Precondition: playerHealth > 0
	 * Postcondition: playerHealth = playerHealth - collisionDmg; In the case that playerHealth becomes negative, takes the user back to the main menu.
	 * 
	 */

	private void healthDetriment() {
		playerHealth -= collisionDmg;
		if(playerHealth <= 0) {
			gameTimer.stop();
			SelectScreen.gameStart = false;
			ViewManager.mainStage.setScene(new MainScreen());
		}
	}
	/**
	 * Creates a collision box around the player and the enemy ships, and then lowers the player's health.
	 * 
	 * Precondition: playerHealth < 100; numberOfEnemy.length > 0
	 * Postcondition: playerHealth = playerHealth - collisionDamage; The struck entity moved back to the right.
	 * 
	 */
	private void collision() {
		for (int i = 0; i < numberOfEnemy.length; i++) {
			if (collisionRadius*2 > distanceFormula(shipImage.getLayoutX()+75, numberOfEnemy[i].getLayoutX() + 75, shipImage.getLayoutY()+35, numberOfEnemy[i].getLayoutY() + 35)) {
				healthDetriment();
				setPosition(numberOfEnemy[i]);
			}
		}
	}
	
	private double distanceFormula(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
	}
}
















