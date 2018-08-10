package io.github.daschnerj.gui;

import io.github.daschnerj.Config;

public class CSSLoader {

    SceneManager sm;

    Config config = new Config("style");
    String type;
    String path;

    public CSSLoader(SceneManager sm)
    {
        this.sm = sm;

        type = config.getDefault("type", "jar ");
        path = config.getDefault("path", "medonaBlack.css");

    }

}
