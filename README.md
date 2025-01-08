# Julia Set Generator

## Overview

This Java application allows users to generate and visualize Julia set fractals, offering interactive controls to dynamically adjust parameters such as constants, coloration, and zoom. The interface is built with Java Swing, providing a graphical user interface to manipulate the fractal parameters and view results in real-time.

## Features

- **Dynamic Parameter Adjustment:** Users can adjust fractal parameters including:
  - `A` and `B` constants for the formula z = z^2 + c, where c = a + bi
  - `Hue`, `Saturation`, `Brightness`, and `Inner Brightness` for color control
  - `Zoom` for focusing on different areas of the fractal
- **Real-Time Visualization:** Changes in parameters immediately update the fractal display.
- **Reset Functionality:** A reset button allows users to return all parameters to their initial states.
- **Save Functionality:** Users can save the current fractal image as a PNG file to their local storage.

## How It Works

- **Adjustment Controls:** Scroll bars are used to adjust the parameters of the fractal. Each scroll bar has associated labels displaying the current value.
- **Image Rendering:** The fractal is rendered based on the Julia set formula with the parameters provided by the user. The rendering updates in real-time as the user adjusts the scroll bars.
- **Saving Images:** The application includes functionality to save the currently displayed fractal as a PNG file using a file dialog.

## Getting Started

### Prerequisites

Ensure you have Java and JDK installed on your system to compile and run Java applications.

### Running the Application

1. **Compile the `JuliaProgram.java` file:**
   - Open your terminal.
   - Navigate to the directory containing `JuliaProgram.java`.
   - Compile the file using the following command:
     ```bash
     javac JuliaProgram.java
     ```
2. **Run the compiled program:**
   - Run the application with the command:
     ```bash
     java JuliaProgram
     ```
3. **Adjust Fractal Parameters:**
   - Use the scroll bars to adjust the parameters (`A`, `B`, `Hue`, `Saturation`, `Brightness`, `Inner Brightness`, `Zoom`).
   - Observe how the fractal image changes in real-time as you manipulate the settings.
4. **Reset Parameters:**
   - Click the 'Reset' button to return all parameters to their default values.
5. **Save the Fractal Image:**
   - Click the 'Save' button.
   - Choose the desired location on your computer to save the fractal image as a PNG file.
