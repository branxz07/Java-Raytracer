# Java-Raytracer (Parallelism included)

Raytracer of 3D object and 2D objects, developed in Java, with **_parallelism for a faster rendering time_** by almost 97%.
Every graphic material is accecible inside the "Readme Files" folder

## Renders

<div style="display: flex; justify-content: space-between; aling-centered: center; ">
     <img src="https://github.com/branxz07/Java-Raytracer/blob/main/Readme%20files/BrandonMaga%C3%B1a_Render01.png" alt="Render 1" style="width: 45%;"/>
    <img src="https://github.com/branxz07/Java-Raytracer/blob/main/Readme%20files/BrandonMaga%C3%B1a_Renders/BrandonMaga%C3%B1a_Render06.png" alt="Render 3" style="width: 45%;"/>
</div>


## How to render?

Follow these steps to render an image using the Java ray tracer:

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/branxz07/Java-Raytracer.git
cd Java-Raytracer
```

### 2. Open the Main Program
Navigate to the main Java program file located at:
 <p>
<strong>"\BrandonMagaña_Code\Ray Tracer Java\src\edu\up\isgc\cg\raytracer\Raytracer.java"</strong>
 </p>

### 3. Set Up Your Scene
In Raytracer.java, you can define a new scene by creating a Scene object and configuring it with a camera, lights, and objects. Here’s an example:

```java
// Create a new scene
Scene scene = new Scene();

// Set up the camera
scene.setCamera(new Camera(
    new Vector3D(0.4, 0.4, -5), // Camera position
    100, // Field of view
    66,  // Aspect ratio
    1920, // Image width
    1080, // Image height
    .6,   // Focal length
    50.0  // Distance to focus
));

// Add lights
scene.addLight(new PointLight(
    new Vector3D(0f, 5, -3), // Light position
    Color.WHITE,            // Light color
    100                     // Light intensity
));

// Add objects to the scene
scene.addObject(OBJReader.getModel3D(
    "CubeQuad.obj", // Model file
    new Vector3D(-3.0, -2.5, 3.0), // Position
    Color.WHITE,   // Color
    250,           // Scale
    10,            // Reflection
    false          // Transparency
));

// Render the scene
BufferedImage image = raytrace(scene);

// Save the rendered image
File outputImage = new File("rendered_image.png");
try {
    ImageIO.write(image, "png", outputImage);
} catch (Exception e) {
    e.printStackTrace();
}
```


### 4. Compile and Run
Ensure you have the required dependencies. Compile and run your Java program

### 5. Check the Output
After running the program, your rendered image will be saved as rendered_image.png in the project directory.


### 6. Customize Your Scene
Modify the Camera, Light, and Object parameters in Raytracer.java to create different scenes and effects. Adjust positions, colors, and properties to achieve the desired results.
For more details, refer to the comments in the Raytracer.java file and explore other resources in the repository.





## How was it made?

<div style="display: flex; flex-direction: column; align-items: center; text-align: center;">

  <p>
    The ray tracer was a challenging project due to its complexity, involving camera setup, lighting, and object rendering. I received substantial help from Dr. Jafet Rodriguez.
  </p>

  <p>
    1. <strong>Point Lights:.</strong> I started with point lights, which provided flexibility in illumination from different angles.
  </p>

  <p>
    2. <strong>Shadows:.</strong> Implemented hard shadows by testing intersections of rays with objects to determine if a light ray was blocked.
  </p>

  <p>
    3. <strong>Phong Reflection Model:.</strong> Added specular highlights using the Phong model, combining ambient, diffuse, and specular colors.
  </p>

  <p>
    4. <strong>Reflection:.</strong> Implemented reflections by casting rays in the opposite direction of the camera and adjusting based on the object's reflectivity.
  </p>

  <p>
    5. <strong>Refraction.</strong> : Applied refraction by calculating direction changes through transparent objects, altering visibility based on object properties.
  </p>
  
   <p>
    6. <strong>Parallelism</strong> : Amplemented using a thread pool (ExecutorService) that creates multiple threads to handle different sections of the image, in this case is set up to "16". Each thread traces rays for specific pixels (Runnable tasks) concurrently. <p><strong>!!! Change the thread number in case of a less capable CPU !!!</strong></p>
  </p>

  <img src="https://github.com/branxz07/Java-Raytracer/blob/main/Readme%20files/BrandonMaga%C3%B1a_Renders/BrandonMaga%C3%B1a_Render03.png" alt="Render 1" style="width: 90%; max-width: 600px;"/>

  <p><strong> UML DIAGRAM AND MORE DETAIL IMAGES IN THE "README FILES" FOLDER OF THE PROJECT REPORT.</strong></p>

</div>


## Disclaimer

This project was developed as part of my Bachelor's degree in System Engineering and Computer Graphics at Universidad Panamericana, but its scope and complexity are comparable to a Master's level project. All code, design decisions, and implementations were crafted by **Brandon Magaña** and  **Dr. Jafet Rodriguez**, with his invaluable guidance and mentorship.

---

### Important Notes:
- **Educational Purpose:** This project is shared for educational and illustrative purposes. While every effort has been made to ensure accuracy, the code may contain errors or unoptimized sections.
- **Provided "As-Is":** No warranties or guarantees are offered regarding functionality, performance, or suitability for any specific purpose. Use the project at your own risk.
- **Attribution:** If you use or adapt any part of this project, proper attribution is required. Please credit the original author when sharing or building upon this work.
- **Prohibited Use:** Redistribution, modification, or commercial use of this code without explicit permission is prohibited.

---

### Contributions:
Feedback, suggestions, or contributions to improve the project are welcome and highly encouraged. However, the responsibility for testing and debugging lies with the user.

--- 

**Special Acknowledgment:** A sincere thank you to my classmates and specially my professor, [**Dr. Arturo Jafet Rodriguez Muñoz**](https://www.linkedin.com/in/arturojafet/?originalSubdomain=mx), for his immense guidance and support throughout the development of this project.


