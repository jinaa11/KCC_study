package kosa.phone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 전화번호 관리 전반적인 기능
public class Manager extends PhoneInfo {
//	private PhoneInfo arr[];
//	private Scanner sc;
	List<PhoneInfo> list;
	private int count;

	public Manager() {
//		arr = new PhoneInfo[10];
		list = new ArrayList<PhoneInfo>();
//		sc = new Scanner(System.in);
	}

	public void addPhoneInfo() {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력 받아
		// PhoneInfo 객체를 생성해서 배열에 추가하는 것
		String dept, position, major, year;
		System.out.println("1. 일반 2. 회사 3.동창");
		System.out.print("메뉴: ");
		String menu = DataInput.sc.nextLine();

		switch (menu) {
		// 일반
		case "1":
			input();
//			arr[count++] = new PhoneInfo(getName(), getPhoneNo(), getBirth());
			list.add(new PhoneInfo(getName(), getPhoneNo(), getBirth()));
			break;
		// 회사
		case "2":
			input();
			System.out.print("부서: ");
			dept = DataInput.sc.nextLine();
			System.out.print("직책: ");
			position = DataInput.sc.nextLine();

//			arr[count++] = new Company(getName(), getPhoneNo(), getBirth(), dept, position);
			list.add(new Company(getName(), getPhoneNo(), getBirth(), dept, position));
			break;
		// 동창
		case "3":
			input();
			System.out.print("전공: ");
			major = DataInput.sc.nextLine();
			System.out.print("학번: ");
			year = DataInput.sc.nextLine();

//			arr[count++] = new Universe(getName(), getPhoneNo(), getBirth(), major, year);
			list.add(new Universe(getName(), getPhoneNo(), getBirth(), major, year));

		}
	}

	public void listPhoneInfo() {
		System.out.println("1. 전체 2. 회사 3.동창");
		System.out.print("메뉴: ");
		String menu = DataInput.sc.nextLine();

		switch (menu) {
		// 일반
		case "1":
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i) instanceof PhoneInfo) {
//					((PhoneInfo) list.get(i)).show();
//				}
//			}

			Iterator<PhoneInfo> it = list.iterator();
			while (it.hasNext()) {
				it.next().show();
			}

			break;

		// 회사
		case "2":
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i) instanceof Company) {
//					((Company) list.get(i)).show();
//				}
//			}

			it = list.iterator();
			while (it.hasNext()) {
				PhoneInfo p1 = it.next();
				if (p1 instanceof Company) {
					p1.show();
				}
			}
			break;

		// 동창
		case "3":
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i) instanceof Universe) {
//					((Universe) list.get(i)).show();
//				}
//			}
			it = list.iterator();
			while (it.hasNext()) {
				PhoneInfo p1 = it.next();
				if (p1 instanceof Universe) {
					p1.show();
				}
			}
		}
	}

	public void searchPhoneInfo() throws Exception {
		// 검색하고자 하는 이름으로 1개의 PhoneInfo 객체의 내용 출력
		System.out.print("검색할 이름: ");
		String name = DataInput.sc.nextLine();
//		int idx = -1;

		PhoneInfo p = list.stream().filter(search -> name.equals(search.getName())).findFirst()
				.orElseThrow(() -> new Exception("존재하지 않는 이름입니다."));

		System.out.println("검색한 이름: " + name);
		p.show();

//		for (int i = 0; i < list.size(); i++) {
//			if (name.equals(list.get(i).getName())) {
//				System.out.println("검색한 이름: " + name);
//				list.get(i).show();
//				idx = i;
//			}
//		}

		// 검색된 내용이 없는 경우
//		if (idx == -1) {
//			System.out.println("존재하지 않는 이름입니다.");
//		}

	}

	public void updatePhoneInfo() throws Exception {
		// 이름을 입력 => 해당 phoneInfo 추출 => 수정 전화번호 입력 => 전화번호 수정이 완료
		System.out.print("수정할 이름: ");
		String name = DataInput.sc.nextLine();
//		int idx = -1;
//
//		for (int i = 0; i < list.size(); i++) {
//			if (name.equals(list.get(i).getName())) {
//				System.out.print("수정할 번호: ");
//				String newPhone = DataInput.sc.nextLine();
//				// 데이터를 수정할 때는 setter 사용
//				list.get(i).setPhoneNo(newPhone);
//				idx = i;
//			}
//		}
//		System.out.println("수정 완료");
//
//		if (idx == -1) {
//			System.out.println("존재하지 않습니다.");
//		}
		PhoneInfo p = list.stream().filter(update -> name.equals(update.getName())).findFirst()
				.orElseThrow(() -> new Exception("존재하지 않는 이름입니다."));

		System.out.print("수정할 번호 입력: ");
		String newPhone = DataInput.sc.nextLine();
		p.setPhoneNo(newPhone);
		System.out.println("전화번호 수정이 완료되었습니다.");

	}

	public void deletePhoneInfo() throws Exception {
		// 이름을 입력 => 대상 객체 위치 검색 => 인덱스 찾기 => 해당 객체 삭제 (뒤에 부터 앞으로 1칸씩 옮기고 마지막 것을 삭제 -
		// 인덱스 하나 감소)
//		System.out.print("삭제할 이름 입력: ");
//		String name = sc.nextLine();
//		int idx = -1;
//		
//		for(int i = 0; i < count; i++) {
//			if(name.equals(arr[i].getName())) {
//				for(int j = i; j < count - 1; j++) {
//					arr[j] = arr[j+1];
//				}
//				count--;
//			}
//		}
//		System.out.println("삭제 완료");
//		
//		if(idx == -1) {
//			System.out.println("존재하지 않습니다.");
//		}

		System.out.print("삭제할 이름 입력: ");
		String name = DataInput.sc.nextLine();
//		int idx = -1;
//
//		for (int i = 0; i < list.size(); i++) {
//			if (name.equals(list.get(i).getName())) {
//				idx = i;
//				list.remove(i);
//			}
//		}
//		System.out.println("삭제 완료");
//
//		if (idx == -1) {
//			System.out.println("존재하지 않습니다.");
//		}

		PhoneInfo p = list.stream().filter(del -> name.equals(del.getName())).findFirst()
				.orElseThrow(() -> new Exception("존재하지 않는 이름입니다."));

		list.remove(p);
		System.out.println("삭제가 완료되었습니다.");

	}

	public void sortPhoneInfo() {
		System.out.println("======== 정렬 기준 선택 ========");
		System.out.println("1.이름 오름차순 2.생년월일 내림차순");
		System.out.print("메뉴: ");
		String menu = DataInput.sc.nextLine();
		switch (menu) {
		case "1":
			Collections.sort(list);
			break;
		case "2":
			Collections.sort(list, new Comparator<PhoneInfo>() {

				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					if (o1.getBirth().compareTo(o2.getBirth()) > 0) {
						return -1;
					} else if (o1.getBirth().compareTo(o2.getBirth()) < 0) {
						return 1;
					}
					return 0;
				}
			});

			break;
		}
	}
	
	public void writePhoneInfo() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("phoneInfo.txt"));
			oos.writeObject(list); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {}
		}
		System.out.println("데이터 저장 완료");
	}
	
	public void readPhoneInfo() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("phoneInfo.txt"));
			list = (List<PhoneInfo>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {}
		}
	}
}
