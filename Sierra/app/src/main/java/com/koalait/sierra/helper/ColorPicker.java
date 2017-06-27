package com.koalait.sierra.helper;

import com.koalait.sierra.R;

/**
 * Created by Sandro on 24.06.2017.
 */

public class ColorPicker {

    public static int getColor(String color) {
        switch (color) {
            case "Deutsch":
                return R.color.german;
            case "Mathematik":
                return R.color.mathe;
            case "Sport":
                return R.color.sport;
            case "Physik":
                return R.color.physic;
            case "Englisch":
                return R.color.english;
            case "Französisch":
                return R.color.french;
            case "Musik":
                return R.color.music;
            case "Handarbeit":
                return R.color.handcraft;
            case "Wirtschaft":
                return R.color.economy;
            case "Geschichte":
                return R.color.history;
            case "Chemie":
                return R.color.chemistry;
            case "Biologie":
                return R.color.biology;
            case "Erdkunde":
                return R.color.geography;
            default:
                return R.color.iron;
        }
    }
}
