/*�迭����] �Ʒ� �ܾ� 5���� �迭�� �����ϰ� ������ �ܾ ������ �� �ܾ� ���� ö�ڸ� ����
	����ڿ��� �����Ѵ�.
	����ڴ� ���õ� ö�ڸ� ���� �ܾ ���ߴ� ����
	�õ� Ƚ���� ����� ��
	[���þ�] hope, apple, banan, orange, love*/

s
package chap05.sec03;     //*****�ٽ��غ���

import java.util.Random;
import java.util.Scanner;

public class WordScambleEx {

	public static void main(String[] args) {
		WordScamble ws=new WordScamble();
//		ws.word[2];						//private �پ��� ������ ������ �� X
		String str=ws.WordSelection();
		String question=ws.shuffle(str); 
		System.out.println("���þ� : "+question);
		ws.answer(str);
	}
}

class WordScamble{
	private String[] word= {"hope", "apple", "banana", "orange", "love"}; //String[] �տ� private ���������� ���̸� - Ŭ���� �ȿ����� ���, Ŭ���� ����� ������ �� X
																		//private���� �����Ǿ��ִ� ����� �����ϱ� ���� ���Ǵ� �޼ҵ�-������ ������ getter  /  setter
	
	public String WordSelection() {
		Random rnd=new Random();
		int idx=rnd.nextInt(5);  // 0~4������ ������ ���� �߻�
		return word[idx];
	}
	
	public String shuffle(String str) {	//String -> ��ȯŸ�� (void ��� �ڸ�)
		char[] ch=str.toCharArray(); 	//toCharArray�޼ҵ� - ���ڿ��� ���ڹ迭�� �ٲ���
		
		for(int i=0; i<1000; i++) {
			int r=(int)(Math.random()*ch.length);  //0<= <1 1���� �۱ⶼ������ length�� -1 X
			char temp=ch[0];
			ch[0]=ch[r];
			ch[r]=temp;    //��ȯŸ�� - ���ڿ�(public String shuffle) , ���� �ܾ��� Ÿ�� - ���ڹ迭 Ÿ��	
							//���ڹ迭�� ���ڿ��� ����������
		}
		return(new String(ch));  //�Ű����� ���ڹ迭 ������ ���ڿ� �����ؾ��� -> �����ڸ޼ҵ� �θ�
		
	}
	
	public void answer(String sss) {			//String question ->���� ���ڿ� �������;���
		Scanner sc=new Scanner(System.in);
		int count=0;							//�õ�Ƚ��
		while(true) {							//���⶧���� �Է¹���  - for-Ƚ���� ���س���.
			System.out.print("\n���� : ");
			String str=sc.nextLine();
			count++;
			if(str.equals(sss)) {
				System.out.println("*******************");
				System.out.println("�����Դϴ�");
				System.out.println("�õ�Ƚ�� : "+count);
				System.out.println("*******************");
				break;
			}else {
				System.out.println("*******************");
				System.out.println("������ �ƴմϴ�");
			}
		}
	}
	
}
