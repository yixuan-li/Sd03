package sd03;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class settings {
	int money;
	int countentry1=0,countentry2=0;
	int countenter1=0;//times of enter edit squad-->add member
	ArrayList<items> itemlist = new ArrayList<items>();
	ArrayList<items> myitemlist = new ArrayList<items>();
	ArrayList<members> member = new ArrayList<members>();
	ArrayList<members> squadmember = new ArrayList<members>();
	
	public settings(int money) {
		this.money=money;
	}
	
	public void choices(int num) {
		switch(num) {
		case 1:
			buyitems();
			break;
		case 2:
			editmembers();
			break;
		case 3:
			checkstatus();
			break;
		default:	
			System.out.println("The number doesn't exist!");
		}	
	}
	
	public void buyitems(){
		countentry1++;
		int count=0;
		if(myitemlist.isEmpty()) {
			System.out.println("No item in my item list!");
		}
		System.out.println("Would you want to buy some items? (1 Yes 2 No): "); 
	    Scanner sc = new Scanner(System.in); 
        int buyitem = sc.nextInt(); 
        while (buyitem==1) {
        	System.out.println("The money you have: "+money); 
        	if(countentry1==1 && count==0) { 
        		System.out.println("index | item name | price | number you have ");
        		itemlist.add(new items(1,"Stone Stick",100));
        		itemlist.add(new items(2,"Dagger",150));
        		itemlist.add(new items(3,"Iron Sword",200));
        		itemlist.add(new items(4,"Bow",300));
        		itemlist.add(new items(5,"Gun",1000));
        	}
        	itemlistInfo();
        	System.out.println("Type the item(index) you'd like to buy? (1-5): "); 
    	    Scanner sc1 = new Scanner(System.in); 
            int itemindex = sc1.nextInt(); 
            for(int i=0;i<itemlist.size();i++) {
            	if(itemlist.get(i).index==itemindex) {
            		if(itemlist.get(i).price<=money) {
            			money=money-itemlist.get(i).price;
            			System.out.println("The money you have after buying: "+money); 
            			itemlist.get(i).itemnum++;
            			if(countentry1==1) {
            				if(itemlist.get(i).itemnum==1) {
            					myitemlist.add(itemlist.get(i));
            				}else {
            					myitemlist.remove(itemlist.get(i));
                				myitemlist.add(itemlist.get(i));
            				}
            			}else { //countentry1>1
            				if(itemlist.get(i).itemnum==1) {
            					myitemlist.add(itemlist.get(i));
            				}else {
            					myitemlist.remove(itemlist.get(i));
                				myitemlist.add(itemlist.get(i));
            				}
            			}
                        System.out.println("Item table has been updated: "); 
                        itemlistInfo();
            		}else {
            			System.out.println("You don't have enough money!");
            		}	
            	}
            }
            count++;
            System.out.println("Continue shopping? (1 Yes 2 No): "); 
    	    Scanner sc2 = new Scanner(System.in); 
            int shopping = sc2.nextInt(); 
            if(shopping==1) {
            	buyitem=1;
            }else {
            	buyitem=2; //don't buy=quit
            }
        }
        System.out.println("Print my item list: ");
        myitemlistInfo();
        System.out.println("Back to settings page.");
        System.out.println("");
	}
	
	public void editmembers() {
    	countentry2++;//times of entry the function
    	int count=0;
    	if(squadmember.isEmpty()) { //setup
    		squadmember.add(new members(1,"Captain1",10,15,13,20,90,120,0,"Captain",true));
        	squadmember.add(new members(6,"Hierophant1",8,13,12,14,85,110,0,"Hierophant",true));
    	}
		System.out.print("Would you want to edit squad members? (1 Add 2 Remove 3 Quit): "); 
	    Scanner sc = new Scanner(System.in); 
        int editmember = sc.nextInt(); 
		while(editmember==1) {	
			countenter1++;
			System.out.println("The money you have: "+money);
			if(countenter1==1 && count==0) { 
				System.out.println("index | name | move | fight | shoot | armour | morale | health | cost | notes | insquad");
        		member.add(new members(11,"Abel",10,9,9,12,70,100,80,"Accuracy",false));
        		member.add(new members(12,"Ben",12,14,8,11,60,90,70,"Fast",false));
        		member.add(new members(13,"Calvin",15,14,10,17,85,150,130,"Fast&Strong",false));
        		member.add(new members(14,"Demi",11,13,10,15,75,110,100,"Strong",false));
        		member.add(new members(15,"Eason",13,10,14,12,70,90,100,"Accuracy",false));
        		member.add(new members(16,"Fang",10,7,9,12,60,80,50,"Strong",false));
        		member.add(new members(17,"George",9,9,9,11,65,100,90,"no special",false));
        		member.add(new members(18,"Young",14,7,8,12,70,110,80,"Fast",false));
        		member.add(new members(19,"Zidane",14,13,9,16,90,140,110,"Fast&Strong",false));
        	}

			memberInfo();
        	System.out.println("Type the index you'd like to buy? (11-19): "); 
    	    Scanner sc1 = new Scanner(System.in); 
            int memberindex = sc1.nextInt();
            for(int i=0;i<member.size();i++) {
            	if(member.get(i).index==memberindex) {
            		if(member.get(i).insquad==true) {
            			System.out.println("Already in Squad!");
            		}
            		else { //Not in squad
            			if(squadmember.size()>10) { //max is 10
            				System.out.println("Reach the max number(10) in Squad!");
            			}else { //number of squad member is 2-10
            				if(money>=member.get(i).cost) { //Have enough money
                    			money=money-member.get(i).cost;
                    			System.out.println("The money you have after buying: "+money); 
                    			member.get(i).insquad=true;
                    			squadmember.add(member.get(i));//get this member
                    			System.out.println("Member table has been updated: "); 
                                memberInfo();
                    		}else {
                    			System.out.println("You don't have enough money!");
                    		}
            			}
            		}// end if: in squad or not
            	} //end if: the member index exist or not
            }//end for: walk through the whole member list
			count++;
    		System.out.print("Continue shopping? [BE CARE] (1 Yes 3 No):"); 
    	    Scanner sc2 = new Scanner(System.in); 
            int shopping = sc2.nextInt(); 
            if(shopping==1) {
            	editmember=1;
            }else {
            	editmember=3; //don't buy=quit
            }
		}
		while(editmember==2) { //Remove
			squadmemberInfo();
			System.out.println("Select which member(index) to remove: ");
			Scanner sc2 = new Scanner(System.in); 
	        int removemember = sc2.nextInt();
	        for(int i=0;i<squadmember.size();i++) {
	        	if(squadmember.get(i).index==removemember){
	        		if(squadmember.get(i).notes!="Captain" && squadmember.get(i).notes!="Hierophant") {
	        			for(int j=0;j<member.size();j++) {
	        				if(squadmember.get(i).index==member.get(j).index) {
	        					member.get(j).insquad=false;
	        					System.out.println("Member table has been updated: "); 
	        					memberInfo();
	        				}
	        			}
	        			squadmember.remove(i);
	        		}else {
	        			System.out.println("You can't remove Captain or Hierophant!");
	        		}
				}
	        }
	        System.out.print("Continue removing? [BE CARE](2 Yes 3 No):"); 
    	    Scanner sc3 = new Scanner(System.in); 
            int shopping = sc3.nextInt(); 
            if(shopping==2) {
            	editmember=2;
            }else {
            	editmember=3; //don't remove=quit
            }
        }
		if(editmember==3) {
			System.out.println("Number of squad members: "+squadmember.size());
			System.out.println("Print squad numbers: ");
	        squadmemberInfo();
	        System.out.println("Back to settings page.");
	        System.out.println("");
		}
	}
	
	public void checkstatus() {
		if(squadmember.isEmpty()) { //setup
			squadmember.add(new members(1,"Captain1",10,15,13,20,90,120,0,"Captain",true));
        	squadmember.add(new members(6,"Hierophant1",8,13,12,14,85,110,0,"Hierophant",true));
        	System.out.println("Print squad numbers: ");
			squadmemberInfo();
		}else {
			System.out.println("Print squad numbers: ");
			squadmemberInfo();
		}
		System.out.println("");
	}
	
	public final void itemlistInfo() {
		ListIterator<items> it = itemlist.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public final void myitemlistInfo() {
		ListIterator<items> it = myitemlist.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public final void squadmemberInfo() {
		ListIterator<members> it = squadmember.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public final void memberInfo() {
		ListIterator<members> it = member.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
