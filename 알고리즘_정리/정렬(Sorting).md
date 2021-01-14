# 정렬(Sorting)    
### 1. Arrays.sort()   
#### int형 배열 정렬   
- 오름차순 .. 기본   
```java
int[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [1, 17, 25, 26, 44, 99, 303]
```   

- 내림차순   
> sort()의 인자에 추가로 Collections.reverseOrder() 해야함.     
```java
Integer[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr, Collections.reverseOrder());
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [303, 99, 44, 26, 25, 17, 1]   
```    
---   
- 부분정렬    
> Arrays.sort(배열, 시작, 끝 index)    
```java   
int[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr, 0, 4);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [1, 17, 25, 26, 99, 44, 303]
```   
---   

#### String형 배열 정렬    
> int형과 동일    
> 아스키코드 값으로 비교하여 정렬함    
- 오름차순   
```java   
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
Arrays.sort(arr);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [Apple, Banana, Cherry, Kiwi, Orange, Watermelon]
```   

- 내림차순   
```java   
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
Arrays.sort(arr, Collections.reverseOrder());
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [Watermelon, Orange, Kiwi, Cherry, Banana, Apple]
```   
---   
- 문자열 길이 순서로 정리   
```java 
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text
// OUTPUT : 
Sorted arr[] : [Kiwi, Apple, Orange, Banana, Cherry, Watermelon]
```   
---   

#### 객체 배열 정렬    
> 이 경우에는 클래스에 Comparable을 구현하여 비교할 수 있게 해야 한다.   
```java   
static class Times implements Comparable<Times>{ //사용예시
		int start;
		int end;
		
		public Times(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Times o) {
			return Integer.compare(this.start, o.start); //시작기준 오름차순
		}
	}
```   
> Integer.compare(this.start, o.start) : 양수, 음수 고려하지 않고 오름차순 정렬하는 방법   
> 인자의 위치 교환시, 내림차순 정렬    
> 클래스에서 정의된 변수를 이용하여 정렬 기준 변수 정할 수 있음   

---   

### 2. collections.sort()   
> 리스트 정렬 시 사용    
> ArrayList, LinkedList .. 등    
---   

### ※ Comparable<T>  VS  Comparator<T>   
	
- Comparable<T>   
> 기본적으로 적용되는 즉, 정렬 기준이되는 메서드를 정의한 인터페이스   
> 변경이 __불가__ 하다    

- Comparator<T>   
> 기본정렬 기준과 다르게 정렬하고 싶을 때 사용하는 인터페이스   
> 변경이 __가능__ 하다.

```java   
static class StudentComparator implements Comparator<Student> { //사용예시
		@Override
		public int compare(Student o1, Student o2) { //도우미 입력 받음
			return Integer.compare(this.no, o.no); 
		} 

	}
```    
> __정렬 방법__  
> - 데이터에 양수, 음수가 섞여 있지 않을  사용       
> return o1.no - o2.no;        
> return -(o1.no - o2.no);          

> - 데이터에 양수, 음수가 섞여있을 때 ... 언더플로우/오버플로우 방지 가능     
> ★ return Integer.compare(this.no, o.no);         
> 마지막 방법으로 정렬해주는 것이 가장 안전!!!      
---   
[참고자료] https://codechacha.com/ko/java-sorting-array/   

