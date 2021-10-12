# ✅ HashMap 
> HashMap은 Map의 일종       
> key와 value의 쌍으로 이루어진 데이터를 보관      

### ✔ 구조   
![image](https://user-images.githubusercontent.com/72757829/135703042-d0ba085b-b45b-4ccd-be6d-5ee99a5ec4ec.png)     

### ✔ 특징
- key의 null, value의 null을 모두 허용     
- 내부적으로 데이터에 접근 시, 동기화를 보장하지 않음
- 데이터의 순서를 보장하지 않음
- 중복된 key값 허용X , 중복된 value는 가능     

### ✔ HashMap의 API    
```
put()
putAll()
get()
remove()
clear()
isEmpty()
keySet()
values()
containsKey()
containsValue()
replace()
```

### ✔ 선언
```java
HashMap<String, Integer> map = new HashMap<>(); //<키 자료형, 값 자료형>
```

### ✔ put() : key, value 저장
```java
    map.put("A", 100);
		map.put("B", 101);
		map.put("C", 102);
		map.put("C", 103); //중복된 key값이면 업데이트됨.
```

- ex) 한 줄로 표현하기
> key가 있으면 1 증가, 아니면 {key, 1}로 새로 추가할 것    
```java
    map.put(key, map.getOrDefault(key, 0)+1);
```

### ✔ get() : map 읽기
```java
    map.get("A");
    map.get("B");
    map.get("C");
```
- 출력
```java
    System.out.println(map);
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
		System.out.println(map.get("C"));
```
- 결과
```
{A=100, B=101, C=103}
100
101
103
```    

### ✔ 값 삭제    
```java
    map.remove("A"); //key값 A 제거
    map.clear(); //모든 값 제거
```

### ✔ containsKey : 키가 있는지 확인 (덮어쓰진 않음)
```java
    if(!map.containsKey("D")) map.put("D", 300); 
```


### ✔ map을 순회하는 방법 2가지    
#### 1. entrySet() 활용     
```java
   for(Map.Entry<String, Integer> e : person.entrySet()){
      e.getKey();
      e.getValue();
    }
```   

#### 2. KeySet() 활용
```java 
    for (Integer i : person.keySet()) {
      Integer key = i;
      Integer value = person.get(i);
    }
```
