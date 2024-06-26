abstract class Shape {
    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    public abstract double calculateSurfaceArea();
    public abstract double calculateVolume();
}
//三角形
class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;  // 平面图形没有表面积
    }

    @Override
    public double calculateVolume() {
        return 0;  // 平面图形没有体积
    }
}
//长方形
class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;  // 平面图形没有表面积
    }

    @Override
    public double calculateVolume() {
        return 0;  // 平面图形没有体积
    }
}
//圆
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;  // 平面图形没有表面积
    }

    @Override
    public double calculateVolume() {
        return 0;  // 平面图形没有体积
    }
}
//正方形
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;  // 平面图形没有表面积
    }

    @Override
    public double calculateVolume() {
        return 0;  // 平面图形没有体积
    }
}
//梯形
class Trapezoid extends Shape {
    private double a, b, h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double calculatePerimeter() {
        double c = Math.sqrt(h * h + Math.pow((a - b) / 2, 2));
        return a + b + 2 * c;
    }

    @Override
    public double calculateArea() {
        return (a + b) * h / 2;
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;  // 平面图形没有表面积
    }

    @Override
    public double calculateVolume() {
        return 0;  // 平面图形没有体积
    }
}
//球
class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 0;  // 立体图形没有周长
    }

    @Override
    public double calculateArea() {
        return 0;  // 立体图形没有面积
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
}
//圆柱
class Cylinder extends Shape {
    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 0;  // 立体图形没有周长
    }

    @Override
    public double calculateArea() {
        return 0;  // 立体图形没有面积
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}
//锥体
class Cone extends Shape {
    private double radius, height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 0;  // 立体图形没有周长
    }

    @Override
    public double calculateArea() {
        return 0;  // 立体图形没有面积
    }

    @Override
    public double calculateSurfaceArea() {
        double l = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + l);
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
}