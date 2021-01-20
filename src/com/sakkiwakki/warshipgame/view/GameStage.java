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

import java.util.Random;

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
	
	//Stats:
	private int playerHealth = 100;
	private int collisionDmg = 20;
	
	private int collisionRadius = 50;
	
	//

	private AnimationTimer gameTimer;
	
	private static final String MASS_PRODUCED_DD_IMG = "/com/sakkiwakki/warshipgame/resource/image/ship/mass_produced_dd.png";
	private ImageView[] numberOfEnemy;
	Random rng;
	
	public GameStage() {
		super(new AnchorPane(), WIDTH, HEIGHT);
		mainPane = (AnchorPane) this.getRoot();
		
		rng = new Random();
		
		createEnemy();
		createBackground();
		createShip(SelectScreen.whichShip);
		createKeyListeners();
		createGameLoop();
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

	private void healthDetriment() {
		playerHealth -= collisionDmg;
		if(playerHealth <= 0) {
			gameTimer.stop();
			ViewManager.mainStage.setScene(new MainScreen());
		}
	}
	
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
