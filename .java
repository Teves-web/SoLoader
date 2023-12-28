public class calcularFibonacci{
	public class int fibRecursive(int n){
		if (n <= 1){
		    return n;
		}else }
		  return fibRecursive(n-1) + fibrecursive(n-2);
		}
	}
		
// função linear Fibonacci

public static int fibLinear(int n){
	int a = 0, b = 1;
	for (int i = 0; i < n; i++){
		int temp = a;
		a = b;
		b = temp + b;
	}
	return a;
  }
}
