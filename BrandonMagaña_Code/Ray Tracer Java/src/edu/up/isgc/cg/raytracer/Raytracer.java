/**
 * [1968] - [2023] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.cg.raytracer;


import edu.up.isgc.cg.raytracer.lights.DirectionalLight;
import edu.up.isgc.cg.raytracer.lights.Light;
import edu.up.isgc.cg.raytracer.lights.PointLight;
import edu.up.isgc.cg.raytracer.objects.*;
import edu.up.isgc.cg.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Brandon Magaña
 * @coauthor Jafet Rodríguez
 */
public class Raytracer {
    public static void main(String[] args) {

        System.out.println(new Date());

        Scene scene03 = new Scene();
        scene03.setCamera(new Camera(new Vector3D(0.4, 0.4, -5), 77, 46, 1920, 1080, .6, 50.0));

        scene03.addLight(new PointLight(new Vector3D(-.5f, 5, 3), Color.WHITE, 100));
        scene03.addLight(new PointLight(new Vector3D(0.0, 1.5, 6), Color.RED, 23.0));
        scene03.addLight(new PointLight(new Vector3D(-0.2, 1.5, -4), Color.WHITE, 10));
        scene03.addLight(new PointLight(new Vector3D(0.0, 1.5, -3.5), Color.yellow, 20));
        scene03.addLight(new DirectionalLight(new Vector3D(0.0, 10, 0.0), Color.WHITE, 10));


        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, -1.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("reina.obj", new Vector3D(0f+3, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, -1.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("rey.obj", new Vector3D(1f + 4 + 1, -1.5, -1.0), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, -1.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("alfilA.obj", new Vector3D(2f+2, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, -1.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("caballoA.obj", new Vector3D(3f+1, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, -1.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("torre.obj", new Vector3D(4f, -1.5, -1.0 + 1), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, -1.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("alfilA.obj", new Vector3D(-2f+3, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, -1.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("caballoA.obj", new Vector3D(-3f+2, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, -1.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("torre.obj", new Vector3D(-3f + 2, -1.5, -1.0 + 3), Color.MAGENTA, 250, 10, false));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 1.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(0f + 1, -1.5, -1.0 + 3), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 1.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(1f, -1.5, -1.0), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 1.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(2f, -1.5, -1.0 + 2), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 1.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(3f, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 1.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(4f, -1.5, -1.0 + 1), Color.MAGENTA, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 1.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-1f, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 1.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-2f, -1.5, -1.0), Color.WHITE,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 1.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-3f, -1.5, -1.0), Color.WHITE,50,10));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 0.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 0.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 0.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 0.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 0.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 0.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 0.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 0.0), Color.WHITE, 50, 10, false));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 2.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 2.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 2.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 2.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 2.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 2.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 2.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 2.0), Color.WHITE, 50, 10, false));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 3.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 3.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 3.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 3.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 3.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 3.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 3.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 3.0), Color.BLACK, 50, 10, false));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 4.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 4.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 4.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 4.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 4.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 4.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 4.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 4.0), Color.WHITE, 50, 10, false));
//
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 5.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(0f, -1.5, 4.0), Color.BLACK,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 5.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(1f, -1.5, 4.0 - 1), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 5.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(2f, -1.5, 4.0 - 2), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 5.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(3f, -1.5, 4.0 - 1), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 5.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(4f, -1.5, 4.0 - 3), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 5.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-1f, -1.5, 4.0), Color.BLACK,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 5.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-2f, -1.5, 4.0), Color.BLACK,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 5.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("peon.obj", new Vector3D(-3f, -1.5, 4.0 - 3), Color.YELLOW, 250, 10, false));

        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0f, -2.5, 6.0), Color.BLACK, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("reina.obj", new Vector3D(0f + 3 - 2, -1.5, 6.0 - 6), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1f, -2.5, 6.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("rey.obj", new Vector3D(1f + 4 + 1, -1.5, 6.0 - 1), Color.YELLOW, 250, 10, false));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(2f, -2.5, 6.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("alfilB.obj", new Vector3D(2f+2, -1.5, 3.0), Color.darkGray,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(3f, -2.5, 6.0), Color.WHITE, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("caballoB.obj", new Vector3D(3f+1, -1.5, 3.0), Color.darkGray,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4f, -2.5, 6.0), Color.BLACK, 50, 10, false)); //scene03.addObject(OBJReader.getModel3D("torre.obj", new Vector3D(4f, -1.5, 6.0), Color.darkGray,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1f, -2.5, 6.0), Color.WHITE, 50, 10, false));//scene03.addObject(OBJReader.getModel3D("alfilB.obj", new Vector3D(-2f+3, -1.5, 3.0), Color.darkGray,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, -2.5, 6.0), Color.BLACK, 50, 10, false));//scene03.addObject(OBJReader.getModel3D("caballoB.obj", new Vector3D(-3f+2, -1.5, 3.0), Color.darkGray,50,10));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-3f, -2.5, 6.0), Color.WHITE, 50, 10, false));
        scene03.addObject(OBJReader.getModel3D("torre.obj", new Vector3D(-3f + 3, -1.5, 6.0), Color.YELLOW, 250, 10, false));
        //scene03.addObject(new Sphere(new Vector3D(0f, 0, -2.0), 1, Color.WHITE, 200, 0, true));
        //scene03.addObject(OBJReader.getModel3D("muro2.obj", new Vector3D(0.0, -.5, 7.0), new Color(135, 207, 235), 0, 0, false));

        Scene scene04 = new Scene();
        scene04.setCamera(new Camera(new Vector3D(0.4, 0.4, -5), 100, 66, 1920, 1080, .6, 50.0));
        scene04.addLight(new PointLight(new Vector3D(0f, 5, -3), Color.WHITE, 100));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(-3.0, -2.5, 3.0), Color.WHITE, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(-1.0, -2.5, 3.0), Color.DARK_GRAY, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(1.0, -2.5, 3.0), Color.WHITE, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(3.0, -2.5, 3.0), Color.DARK_GRAY, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(-3.0, -2.5, 5.0), Color.DARK_GRAY, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(-1.0, -2.5, 5.0), Color.WHITE, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(1.0, -2.5, 5.0), Color.DARK_GRAY, 250, 10, false));
        scene04.addObject(OBJReader.getModel3D("CubeQuad.obj", new Vector3D(3.0, -2.5, 5.0), Color.WHITE, 250, 10, false));

        scene04.addObject(new Sphere(new Vector3D(-.5f, 0, 6.50), 1, Color.GREEN, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(-.5f, 0, 4.0), 1, Color.RED, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(2f, 1.5, 4.0), 1, Color.GREEN, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(-.5f, 3, 4.0), 1, Color.BLUE, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(2f, 4.5, 4.0), 1, Color.WHITE, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(-.5f, 6, 4.0), 1, Color.YELLOW, 200, 100, false));
        scene04.addObject(new Sphere(new Vector3D(2f, 7.5, 4.0), 1, Color.CYAN, 200, 100, false));

        Scene scene07 = new Scene();
        scene07.setCamera(new Camera(new Vector3D(0.4, 0.4, -5), 77, 46, 1920, 1080, .6, 50.0));
        scene07.addLight(new PointLight(new Vector3D(2.6, 1.0, -3.0), Color.WHITE, 20));
        scene07.addObject(new Sphere(new Vector3D(0.0, 0.0, 0.0), 1, Color.CYAN, 30, 0, true));
        scene07.addLight(new PointLight(new Vector3D(2.6, 0.0, 1.0), Color.WHITE, 30));
        scene07.addObject(OBJReader.getModel3D("SmallTeapot.obj", new Vector3D(-0.3, -1.0, 2.0), Color.RED, 50, 0, false));

        BufferedImage image = raytrace(scene03);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(new Date());
    }

    public static void parallelMethod(Camera mainCamera, double[] nearFarPlanes, double cameraZ, BufferedImage image, List<Object3D> objects, List<Light> lights) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                Runnable runnable = draw(image, positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, lights);
                executorService.execute(runnable);
            }
        }
        System.out.println(new Date());
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(6, TimeUnit.HOURS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("Cancel non-finished");
            }
        }
        executorService.shutdownNow();
    }

    public static Runnable draw(BufferedImage image, Vector3D[][] positionsToRaytrace, int i, int j, Camera mainCamera, List<Object3D> objects, double cameraZ, double[] nearFarPlanes, List<Light> lights) {
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                Color color = decideColor(positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, lights);
                image.setRGB(i, j, color.getRGB());
            }
        };

        return aRunnable;
    }

    public static Color decideColor(Vector3D[][] positionsToRaytrace, int i, int j, Camera mainCamera, List<Object3D> objects, double cameraZ, double[] nearFarPlanes, List<Light> lights) {
        double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
        double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
        double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

        Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
        Intersection closestIntersection = raycast(ray, objects, null, new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

        Color pixelColor = Color.BLACK;
        if (closestIntersection != null && closestIntersection.getObject().isTransparency() == false) {
            Color objColor = closestIntersection.getObject().getColor();

            for (Light light : lights) {
                Ray detectray = new Ray(closestIntersection.getPosition(), light.getPosition());
                Intersection closestIntersectionLight = raycast(detectray, objects, closestIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                if (closestIntersectionLight == null && closestIntersection.getObject().isTransparency() == false) {
                    double nDotL = light.getNDotL(closestIntersection);
                    double intensity = light.getIntensity() * nDotL;
                    Color lightColor = light.getColor();

                    double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};
                    double[] objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                    for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                        objColors[colorIndex] *= (intensity / Math.pow((Vector3D.magnitude(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()))), 2.5)) * lightColors[colorIndex];
                    }

                    Vector3D N = closestIntersection.getNormal();
                    Color diffuse = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                    pixelColor = addColor(pixelColor, diffuse);
                    if (!light.getClass().getCanonicalName().endsWith("DirectionalLight") && closestIntersection.getObject().isTransparency() == false) {
                        Vector3D P = closestIntersection.getPosition();
                        Vector3D V = Vector3D.normalize((Vector3D.substract(mainCamera.getPosition(), P)));
                        Vector3D L = light.getPosition();
                        Vector3D H = Vector3D.normalize(Vector3D.add(L, V));

                        double specular = Math.pow(Vector3D.dotProduct(N, H), 4 * closestIntersection.getObject().getShininess());

                        objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                            objColors[colorIndex] *= intensity * lightColors[colorIndex] * specular;
                        }

                        Color blinn = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                        pixelColor = addColor(pixelColor, blinn);
                    }

                    pixelColor = addColor(pixelColor, reflection(positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, light, closestIntersection, 4));


                }
            }
        } else if (closestIntersection != null && closestIntersection.getObject().isTransparency() == true) {
            for (Light light : lights) {
                pixelColor = addColor(pixelColor, refraction(positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, light, closestIntersection, 4));
            }

        }

        return pixelColor;
    }

    public static Color refraction(Vector3D[][] positionsToRaytrace, int i, int j, Camera mainCamera, List<Object3D> objects, double cameraZ, double[] nearFarPlanes, Light light, Intersection closestIntersection, int depth) {
        if (depth == 0) {
            return Color.BLACK;
        }
        double nr = 3;
        // ... código anterior ...

// Calcular el ángulo de incidencia
        double cosI = -(Vector3D.dotProduct(closestIntersection.getNormal(), Vector3D.substract(mainCamera.getPosition(), closestIntersection.getPosition())));

// Calcular el ángulo de refracción
        double sinT2 = (1.0 - cosI * cosI);
        if (sinT2 > 1.0) {
            // Si el ángulo de refracción es mayor a 1, significa que no hay refracción (total internal reflection)
            // En este caso, puedes devolver un color predeterminado (por ejemplo, negro)
            return Color.BLACK;
        }

        double cosT = Math.sqrt(1.0 - sinT2);

// Calcular el rayo refractado
        Vector3D R1 = Vector3D.scalarMultiplication(closestIntersection.getNormal(), (cosT * cosI));
        Vector3D R2 = Vector3D.add(Vector3D.scalarMultiplication(Vector3D.substract(mainCamera.getPosition(), closestIntersection.getPosition()), 1), R1);

// Aplicar dispersión cromática
        // ... código anterior ...

// Aplicar dispersión cromática
        double dispersionFactor = 0.03; // Factor de dispersión ajustable (puedes experimentar con diferentes valores)

// Generar un vector aleatorio de dirección para la dispersión cromática
        double offsetX = Math.random() * 2 - 1; // Generar una coordenada x aleatoria en el rango [-1, 1]
        double offsetY = Math.random() * 2 - 1; // Generar una coordenada y aleatoria en el rango [-1, 1]
        double offsetZ = Math.random() * 2 - 1; // Generar una coordenada z aleatoria en el rango [-1, 1]
        Vector3D dispersionOffset = Vector3D.scalarMultiplication(Vector3D.normalize(new Vector3D(offsetX, offsetY, offsetZ)), (dispersionFactor));

// Añadir dispersión cromática al rayo refractado
        R2 = Vector3D.add(R2, dispersionOffset);

// ... más código para el trazado del rayo refractado ...


// ... más código para el trazado del rayo refractado ...


        Ray reflect = new Ray(closestIntersection.getPosition(), R2);
        Intersection reflectionIntersection = raycast(reflect, objects, closestIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        Color pixelColor = new Color(0, 0, 0);
        if (reflectionIntersection != null) {
            Color objColor = reflectionIntersection.getObject().getColor();
            Color reflectColor = reflectionIntersection.getObject().getColor();
            Ray detectray = new Ray(reflectionIntersection.getPosition(), light.getPosition());
            Intersection closestIntersectionLight = raycast(detectray, objects, reflectionIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
            if (closestIntersectionLight == null) {
                double nDotL = light.getNDotL(reflectionIntersection);
                double intensity = light.getIntensity() * nDotL;
                Color lightColor = light.getColor();

                double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};
                double[] objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                    objColors[colorIndex] *= (intensity / Math.pow((Vector3D.magnitude(Vector3D.substract(light.getPosition(), reflectionIntersection.getPosition()))), 2.5)) * lightColors[colorIndex];
                }

                pixelColor = addColor(pixelColor, refraction(positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, light, reflectionIntersection, depth - 1));

                Vector3D N = reflectionIntersection.getNormal();
                Color diffuse = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                pixelColor = addColor(pixelColor, diffuse);
                if (!light.getClass().getCanonicalName().endsWith("DirectionalLight")) {
                    Vector3D P = reflectionIntersection.getPosition();
                    Vector3D V = Vector3D.normalize((Vector3D.substract(mainCamera.getPosition(), P)));
                    Vector3D L = light.getPosition();
                    Vector3D H = Vector3D.normalize(Vector3D.add(L, V));

                    double specular = Math.pow(Vector3D.dotProduct(N, H), 4 * reflectionIntersection.getObject().getShininess());

                    objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                    for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                        objColors[colorIndex] *= intensity * lightColors[colorIndex] * specular;
                    }

                    Color blinn = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                    pixelColor = addColor(pixelColor, blinn);
                }

            }

            float newred = (float) ((pixelColor.getRed() / 255));
            float newgreen = (float) ((pixelColor.getGreen() / 255));
            float newblue = (float) ((pixelColor.getBlue() / 255));
            return new Color(newred, newgreen, newblue);

        }
        return Color.BLACK;
    }

    public static Color reflection(Vector3D[][] positionsToRaytrace, int i, int j, Camera mainCamera, List<Object3D> objects, double cameraZ, double[] nearFarPlanes, Light light, Intersection closestIntersection, int depth) {
        if (depth == 0) {
            return Color.BLACK;
        }
        Vector3D N2 = closestIntersection.getNormal();
        Vector3D V2 = Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
        Vector3D R = Vector3D.normalize(Vector3D.add(Vector3D.scalarMultiplication(Vector3D.scalarMultiplication(N2, Vector3D.dotProduct(V2, N2)), -2), V2));

        Ray reflect = new Ray(closestIntersection.getPosition(), R);
        Intersection reflectionIntersection = raycast(reflect, objects, closestIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        Color pixelColor = new Color(0, 0, 0);
        if (reflectionIntersection != null) {
            Color objColor = reflectionIntersection.getObject().getColor();
            if (!reflectionIntersection.getObject().isTransparency()) {
                Color reflectColor = reflectionIntersection.getObject().getColor();
                Ray detectray = new Ray(reflectionIntersection.getPosition(), light.getPosition());
                Intersection closestIntersectionLight = raycast(detectray, objects, reflectionIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                if (closestIntersectionLight == null) {
                    double nDotL = light.getNDotL(reflectionIntersection);
                    double intensity = light.getIntensity() * nDotL;
                    Color lightColor = light.getColor();

                    double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};
                    double[] objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                    for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                        objColors[colorIndex] *= (intensity / Math.pow((Vector3D.magnitude(Vector3D.substract(light.getPosition(), reflectionIntersection.getPosition()))), 2.5)) * lightColors[colorIndex];
                    }

                    pixelColor = addColor(pixelColor, reflection(positionsToRaytrace, i, j, mainCamera, objects, cameraZ, nearFarPlanes, light, reflectionIntersection, depth - 1));

                    Vector3D N = reflectionIntersection.getNormal();
                    Color diffuse = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                    pixelColor = addColor(pixelColor, diffuse);
                    if (!light.getClass().getCanonicalName().endsWith("DirectionalLight")) {
                        Vector3D P = reflectionIntersection.getPosition();
                        Vector3D V = Vector3D.normalize((Vector3D.substract(mainCamera.getPosition(), P)));
                        Vector3D L = light.getPosition();
                        Vector3D H = Vector3D.normalize(Vector3D.add(L, V));

                        double specular = Math.pow(Vector3D.dotProduct(N, H), 4 * reflectionIntersection.getObject().getShininess());

                        objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                            objColors[colorIndex] *= intensity * lightColors[colorIndex] * specular;
                        }

                        Color blinn = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                        pixelColor = addColor(pixelColor, blinn);
                    }

                }
                float newred = (float) ((pixelColor.getRed() / 255) * reflectionIntersection.getObject().getReflect() / 100.0);
                float newgreen = (float) ((pixelColor.getGreen() / 255) * reflectionIntersection.getObject().getReflect() / 100.0);
                float newblue = (float) ((pixelColor.getBlue() / 255) * reflectionIntersection.getObject().getReflect() / 100.0);
                return new Color(newred, newgreen, newblue);
            }
        }
        return Color.BLACK;
    }

    public static BufferedImage raytrace(Scene scene) {

        Camera mainCamera = scene.getCamera();
        double[] nearFarPlanes = mainCamera.getNearFarPlanes();
        double cameraZ = mainCamera.getPosition().getZ();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        List<Object3D> objects = scene.getObjects();
        List<Light> lights = scene.getLights();

        parallelMethod(mainCamera, nearFarPlanes, cameraZ, image, objects, lights);

        return image;
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

    public static Color addColor(Color original, Color otherColor) {
        float red = clamp((original.getRed() / 255.0) + (otherColor.getRed() / 255.0), 0, 1);
        float green = clamp((original.getGreen() / 255.0) + (otherColor.getGreen() / 255.0), 0, 1);
        float blue = clamp((original.getBlue() / 255.0) + (otherColor.getBlue() / 255.0), 0, 1);
        return new Color(red, green, blue);
    }

    public static Intersection raycast(Ray ray, List<Object3D> objects, Object3D caster, double[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    double intersectionZ = intersection.getPosition().getZ();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersectionZ >= clippingPlanes[0] && intersectionZ <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }

        }

        return closestIntersection;
    }

}
