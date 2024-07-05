package xyz.faewulf.squaremap_area.util;

import xyz.jpenilla.squaremap.api.Point;

import java.util.List;

public class Area {
    public List<Point> points;
    public String color;
    public String name;

    public Area(List<Point> points, String color, String name) {
        this.points = points;
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return "area{" +
                "pointList=" + points +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
