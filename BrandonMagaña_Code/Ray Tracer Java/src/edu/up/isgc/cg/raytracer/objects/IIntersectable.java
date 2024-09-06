/**
 * [1968] - [2023] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;

/**
 * @author Brandon Magaña
 * @coauthor Jafet Rodríguez
 */
public interface IIntersectable {
    Intersection getIntersection(Ray ray);
}
