/**
 * [1968] - [2023] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Brandon Magaña
 * @coauthor Jafet Rodríguez
 */
public abstract class Object3D implements IIntersectable{
    private boolean intersect=false;
    private Color color;
    private Vector3D position;
    private double shininess;
    private double reflect;
    private  boolean transparency;
    public Object3D(Vector3D position, Color color, double shininess, double reflect, boolean transparency) {
        setPosition(position);
        setColor(color);
        setShininess(shininess);
        setReflect(reflect);
        setTransparency(transparency);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public double getReflect() {
        return reflect;
    }

    public void setReflect(double reflect) {
        this.reflect = clamp(reflect,0,100);
    }

    public boolean isTransparency() {
        return transparency;
    }

    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    public static float clamp(double value, double min, double max) {
        if (value < min) {
            return (float) min;
        }
        if (value > max) {
            return (float) max;
        }
        return (float) value;
    }
}
