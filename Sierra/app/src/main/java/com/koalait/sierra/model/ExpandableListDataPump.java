package com.koalait.sierra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sandro on 30.05.2017.
 */

public class ExpandableListDataPump {

        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

            List<String> cricket = new ArrayList<String>();
            cricket.add("Buch Seite 5-6");

            List<String> football = new ArrayList<String>();
            football.add("Dossier Grammatik fertig");

            List<String> basketball = new ArrayList<String>();
            basketball.add("Vortrag über Paris");

            expandableListDetail.put("Montag 05.06.2017 - Mathematik", cricket);
            expandableListDetail.put("Montag 05.06.2017 - Deutsch", football);
            expandableListDetail.put("Montag 05.06.2017 - Franzöisch", basketball);
            return expandableListDetail;
        }
    }

