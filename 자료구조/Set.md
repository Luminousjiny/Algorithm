# 🎏 Set   
> ** 특징 **   
> 1. 중복을 허용하지 않는다. -> List는 중복을 허용함     
> 2. 저장 순서가 보장되지 않는다. 
> 3. null 값을 저장할 수 있다.   
> 4. 내부적으로 HashMap을 사용하여 데이터를 저장   

---   
## 🎐 Set 인터페이스를 구현한 주요 클래스 3개   
### 1. HashSet   
> 순서가 필요없는 데이터를 hash table에 저장    
> set중에서 가장 성능이 좋음   
### 2. TreeSet   
> 저장된 데이터 값에 따라 정렬   
> red-black tree 타입으로 값이 저장   
> HashSet보다 성능이 느림   
### 3. LinkedHashSet   
> 연결된 목록 타입으로 구현된 hash table에 데이터 저장.    
> 저장된 순서에 따라 값이 정렬.    
> 셋 중 가장 느림   
_보편적으로 HashSet 가장 많이 사용_   
_hashset이 가장 빠르지만, 수백만 건의 데이터를 처리하는게 아니면 크게 체감하기는 힘들다고 함_   
---    

# 🎏 HashSet   
### 🎐 제공 메소드 종류
```text   
add()
remove()
removeAll()
removeIf()
size()
clear()
contains()
iterator()
isEmpty()
```
---   
### 1. 선언   
```java 
HashSet<String> alphabetSet = new HashSet<>();
Set<String> alphabetSet = new HashSet<>();
```   
_ 둘 중 아무거나 사용 가능_   
_ 종류 상관 없이 사용하려고 Set객체로 구현함_    
_ ※ ArrayList도 List로 구현하는 것이 더 좋음_   

### 2. 값을 가져오는 방법   
```java   
      Iterator hi = hs.iterator();
      while(hi.hasNext()){
         System.out.println(hi.next());
      }
```   
_메소드 iterator는 인터페이스 Collection에 정의_     
##### ◽ hasNext    
  - 반복할 데이터가 더 있으면 true, 더 이상 반복할 데이터가 없다면 false를 리턴한다.    
##### ◽ next   
  - hasNext가 true라는 것은 next가 리턴할 데이터가 존재한다는 의미다.    
  
---    
### ✔ 추가    
### 3. HashSet.add()   
> add() 메소드 사용 ... 객체가 Set에 저장되면 true, 아니면 false 반환   
---   
### ✔ 삭제 
### 4. HashSet.remove()   
> remove()메소드 사용 ... 객체가 Set에서 삭제되었으면 true, 아니면 false 반환
```java   
Set<String> fruits = new HashSet<String>();
fruits.add("apple");
fruits.add("banana");
fruits.add("kiwi");
System.out.println("fruits: " + fruits);

fruits.remove("apple");
System.out.println("fruits: " + fruits);

// fruits: [banana, apple, kiwi]
// fruits: [banana, kiwi]
```   

### 4. HashSet.removeAll()   
>  ArrayList에 있는 객체를 삭제    
```java   
Set<String> fruits = new HashSet<String>();
fruits.add("apple");
fruits.add("banana");
fruits.add("kiwi");
System.out.println("fruits: " + fruits);

List<String> removed = new ArrayList<>();
removed.add("apple");
removed.add("kiwi");

fruits.removeAll(removed);
System.out.println("fruits: " + fruits);

// fruits: [banana, apple, kiwi]
// fruits: [banana]
```   
### 5. HashSet.removeIf()   
> 인자로 람다식을 받을 수 있음   
> 조건에 충족하는 객체 삭제   
### 6. HashSet.clear()   
> 모두 삭제   
```java   
Set<String> fruits = new HashSet<String>();
fruits.add("apple");
fruits.add("banana");
fruits.add("kiwi");
System.out.println("fruits: " + fruits);

fruits.clear();
System.out.println("fruits: " + fruits);

// fruits: [banana, apple, kiwi]
// fruits: []
```   

---   
### ✔ 존재여부    
### 7. HashSet.contains()   
> Set안에 객체가 존재하는지 여부 리턴 - true/ false   
```java   
Set<String> fruits = new HashSet<String>();
fruits.add("apple");
fruits.add("banana");
fruits.add("kiwi");

System.out.println("has apple? " + fruits.contains("apple"));
System.out.println("has grape? " + fruits.contains("grape"));

// has apple? true
// has grape? false
```   

### 8. HashSet.isEmpty()   
> isEmpty() : Set에 저장된 아이템이 없으면 True를 리턴   

---   
### ✔ 객체 리턴    
### 9. HashSet.iterator()   
> iterator() : Iterator 객체를 리턴   
>     ... Set의 모든 아이템 순회 가능   
```java   
Set<String> fruits = new HashSet<String>();
fruits.add("apple");
fruits.add("banana");
fruits.add("kiwi");

Iterator<String> it = fruits.iterator();
while (it.hasNext())
    System.out.println("fruits: " + it.next());

// fruits: banana
// fruits: apple
// fruits: kiwi
```   
### 10. for을 이용한 접근   
```java   
for (String fruit : fruits) {
    System.out.println("fruits: " + fruit);
}

// fruits: banana
// fruits: apple
// fruits: kiwi
```   
---    
### ✔ 사이즈   
> HashSet에 저장된 아이템 개수를 리턴   


[참고자료]    
- https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/   
- https://codechacha.com/ko/java-collections-hashset/   
- https://opentutorials.org/course/1223/6446   
