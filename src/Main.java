import java.util.Scanner;

class NonlinearSystem {
    private double r;
    private double x;

    public NonlinearSystem(double r, double x0) {
        this.r = r;
        this.x = x0;
    }

    public void runSimulation(int steps) {
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-10s | %-10s | %-40s%n", "步數 (n)", "狀態值 (x)", "可視化波動圖");
        System.out.println("-".repeat(60));

        for (int i = 1; i <= steps; i++) {
            // 非線性公式計算
            x = r * x * (1 - x);

            // 產生 ASCII 圖示：將 0~1 的值映射到 0~30 個字元寬度
            int visualWidth = (int) (x * 30);
            String bar = "*".repeat(visualWidth);
            
            // 輸出格式化結果
            System.out.printf("n=%-7d | x=%-8.4f | %s%n", i, x, bar);
        }
        System.out.println("=".repeat(60));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>> 非線性系統 (Logistic Map) 終端機模擬器 <<<");
        
        System.out.print("請輸入增益參數 r (試試 3.7): ");
        double r = scanner.nextDouble();
        
        System.out.print("請輸入初始狀態 x0 (0~1): ");
        double x0 = scanner.nextDouble();
        
        System.out.print("請輸入迭代步數: ");
        int steps = scanner.nextInt();

        NonlinearSystem system = new NonlinearSystem(r, x0);
        system.runSimulation(steps);

        scanner.close();
    }
}