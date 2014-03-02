package com.apptonix.psw;

import com.apptonix.ProjectSkyWarrior.ProjectSkyWarrior;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "project-sky-warrior";
		cfg.useGL20 = false;
		cfg.width = 1280;
		cfg.height = 720;
		
		new LwjglApplication(new ProjectSkyWarrior(), cfg);
	}
}
