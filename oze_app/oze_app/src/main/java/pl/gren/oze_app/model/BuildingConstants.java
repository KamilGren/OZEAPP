package pl.gren.oze_app.model;

import java.util.HashMap;
import java.util.Map;

public class BuildingConstants {

    public static final Map<String, Double> BUILDING_TYPE_MULTIPLIERS1 = new HashMap<>();
    public static final Map<String, Double> BUILDING_TYPE_MULTIPLIERS2 = new HashMap<>();
    public static final Map<String, Double> WALL_TYPE_VALUES = new HashMap<>();
    public static final Map<String, Double> ISOLATION_VALUES = new HashMap<>();

    static {
        // Mapy dla buildingType

        BUILDING_TYPE_MULTIPLIERS1.put("singleStory", 1.0);
        BUILDING_TYPE_MULTIPLIERS1.put("singleStoryWithHabitableAttic", 1.2);
        BUILDING_TYPE_MULTIPLIERS1.put("singleStoryWithNonHabitableAttic", 1.2);
        BUILDING_TYPE_MULTIPLIERS1.put("multiStory", 2.0);
        BUILDING_TYPE_MULTIPLIERS1.put("multiStoryWithHabitableAttic", 2.5);

        BUILDING_TYPE_MULTIPLIERS2.put("singleStory", 1.1);
        BUILDING_TYPE_MULTIPLIERS2.put("singleStoryWithHabitableAttic", 1.5);
        BUILDING_TYPE_MULTIPLIERS2.put("singleStoryWithNonHabitableAttic", 1.1);
        BUILDING_TYPE_MULTIPLIERS2.put("multiStory", 1.1);
        BUILDING_TYPE_MULTIPLIERS2.put("multiStoryWithHabitableAttic", 1.5);

// Map for wallType
        WALL_TYPE_VALUES.put("ceramicBrick", 0.77);
        WALL_TYPE_VALUES.put("concreteBlock", 0.5);
        WALL_TYPE_VALUES.put("ceramicBlock", 0.5);
        WALL_TYPE_VALUES.put("wooden", 0.16);
        WALL_TYPE_VALUES.put("frame", 0.1);
        WALL_TYPE_VALUES.put("concrete", 1.0);
        WALL_TYPE_VALUES.put("aeratedConcrete", 0.17);
        WALL_TYPE_VALUES.put("porotherm", 0.079);
        WALL_TYPE_VALUES.put("ytong", 0.095);
        WALL_TYPE_VALUES.put("silicate", 0.8);
        WALL_TYPE_VALUES.put("cinderConcrete", 0.56);

// Map for insulation
        ISOLATION_VALUES.put("styrofoam", 0.031);
        ISOLATION_VALUES.put("graphiteStyrofoam", 0.029);
        ISOLATION_VALUES.put("XPS", 0.045);
        ISOLATION_VALUES.put("mineralWool", 0.035);
        ISOLATION_VALUES.put("polyurethaneFoam", 0.023);
    }

    public static final Map<Integer, Map<Integer, Double>> BASEMENT_FLOOR_VALUES = new HashMap<>();
    public static final Map<Integer, Map<Integer, Double>> BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION = new HashMap<>();


    static {
        BASEMENT_FLOOR_VALUES.put(0, createRow(0, 2, 1, 0.5, 0.3));
        BASEMENT_FLOOR_VALUES.put(2, createRow(0.86, 0.58, 0.44, 0.28, 0.16));
        BASEMENT_FLOOR_VALUES.put(4, createRow(0.64, 0.48, 0.38, 0.26, 0.16));
        BASEMENT_FLOOR_VALUES.put(6, createRow(0.52, 0.4, 0.33, 0.25, 0.15));
        BASEMENT_FLOOR_VALUES.put(8, createRow(0.44, 0.35, 0.29, 0.23, 0.15));
        BASEMENT_FLOOR_VALUES.put(10, createRow(0.38, 0.31, 0.26, 0.21, 0.14));
        BASEMENT_FLOOR_VALUES.put(12, createRow(0.34, 0.28, 0.24, 0.19, 0.14));
        BASEMENT_FLOOR_VALUES.put(14, createRow(0.3, 0.25, 0.22, 0.18, 0.13));
        BASEMENT_FLOOR_VALUES.put(16, createRow(0.28, 0.23, 0.2, 0.17, 0.12));
        BASEMENT_FLOOR_VALUES.put(18, createRow(0.25, 0.22, 0.19, 0.16, 0.12));
        BASEMENT_FLOOR_VALUES.put(20, createRow(0.24, 0.2, 0.18, 0.15, 0.11));

        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(0, createRow(0, 2, 1, 0.5, 0.3));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(2, createRow(1.3, 0.77, 0.55, 0.33, 0.17));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(4, createRow(0.88, 0.59, 0.45, 0.3, 0.17));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(6, createRow(0.68, 0.48, 0.38, 0.27, 0.17));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(8, createRow(0.55, 0.41, 0.33, 0.25, 0.16));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(10, createRow(0.47, 0.36, 0.3, 0.23, 0.15));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(12, createRow(0.41, 0.32, 0.27, 0.21, 0.14));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(14, createRow(0.37, 0.29, 0.24, 0.19, 0.14));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(16, createRow(0.33, 0.26, 0.22, 0.18, 0.13));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(18, createRow(0.31, 0.24, 0.21, 0.17, 0.12));
        BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.put(20, createRow(0.28, 0.22, 0.19, 0.16, 0.12));
    }

    private static Map<Integer, Double> createRow(double... values) {
        Map<Integer, Double> row = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            row.put(i + 1, values[i]);
        }
        return row;
    }
}