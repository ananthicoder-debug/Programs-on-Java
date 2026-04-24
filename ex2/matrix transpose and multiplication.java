import java.util.*;
class Matrix {
        int rows,cols;
        int [][] data;
        Matrix (int rows,int cols)
        {
                this.rows=rows;
                this.cols=cols;
                data=new int[rows][cols];
        }
        void readMatrix()
        {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter matrix elements");
                for(int i=0;i<rows;i++) {
                        for(int j=0;j<cols;j++) {
                                data[i][j]=in.nextInt();
                                }
                }
        }
        void transpose()
        {
                System.out.println("Matrix transpose");
                for(int i=0;i<rows;i++) {
                        for(int j=0;j<cols;j++) {
                                System.out.printf("%d\t",data[j][i]);
                                }
                        System.out.println();
                }
        }
        void matmul(Matrix m1,Matrix m2) {
                if(m1.cols==m2.rows) {
                        //Matrix res=new Matrix(m1.rows,m2.cols);
                        for(int i=0;i<m1.rows;i++) {
                                for(int j=0;j<cols;j++) {
                                        for(int k=0;k<m1.cols;k++) {
                                                this.data[i][j]+=m1.data[i][k]*m2.data[k][j];
                                        }
                                }
                        }
                        System.out.println("Multiplied matrix");
                        this.displayMatrix();
                }
                else {
                        System.out.println("Matrix 1 colums and Matrix 2 rows must be equal");
                }
        }
        void rowSum() {
                int sum=0;
                for(int i=0;i<rows;i++) {
                        for(int j=0;j<cols;j++) {
                                sum+=data[i][j];
                        }
                        System.out.printf("Sum of row[%d]:%d\n",i+1,sum);
                        sum=0;
                }

        }
        void colSum() {
                int sum=0;
                for(int i=0;i<rows;i++) {
                        for(int j=0;j<cols;j++) {
                                sum+=data[j][i];
                        }
                        System.out.printf("Sum of column[%d]:%d\n",i+1,sum);
                        sum=0;
                }
        }
        void displayMatrix()
        {
                System.out.println("Matrix Details");
                for(int i=0;i<rows;i++)
                {
                        for(int j=0;j<cols;j++)
                        {
                                System.out.printf("%d\t",data[i][j]);
                        }
                        System.out.println();
                }
        }
}

public class MatrixPgm {

        public static void main(String[] args) {
                int r,c,r2,c2;
                Scanner in =new Scanner(System.in);
                System.out.println("Enter rows for matrix 1:");
                r=in.nextInt();
                System.out.println("Enter columns for matrix 1:");
                c=in.nextInt();
                Matrix m1=new Matrix(r,c);
                m1.readMatrix();
                System.out.println("Enter rows for matrix 2:");
                r2=in.nextInt();
                System.out.println("Enter columns for matrix 2:");
                c2=in.nextInt();
                Matrix m2=new Matrix(r2,c2);
                m2.readMatrix();
                //display matrix
                m1.displayMatrix();
                m2.displayMatrix();
                //matrix transpose
                m1.transpose();
                m2.transpose();
                //matrix multiplication
                Matrix m3=new Matrix(r,c2);
                m3.matmul(m1, m2);
                //Rows and column sum
                System.out.println("Matrix 1");
                m1.rowSum();
                m1.colSum();
                System.out.println("Matrix 2");
                m2.rowSum();
                m2.colSum();
                System.out.println("Matrix 3");
                m3.rowSum();
                m3.colSum();
        }

}
