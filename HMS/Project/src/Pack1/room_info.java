package Pack1;

import java.io.Serializable;

public class room_info implements Serializable{
	

    private static final long serialVersionUID = 1L;
	private String Rno;
	private String Rtype;
	private String Bno;
	private String Rcat;
	private String Price;
	private boolean status;
	
	

	public  room_info(String Rno,String Rtype,String Bno,String Rcat,String Price,boolean status)
	{
		super();
		this.Rno = Rno;
        this.Rtype=Rtype;
		this.Bno=Bno;
		this.Rcat=Rcat;
		this.Price=Price;
		this.status=status;
	}
	
	public String getRno() {
		return Rno;
	}

	public void setRno(String rno) {
		Rno = rno;
	}

	public String getRtype() {
		return Rtype;
	}

	public void setRtype(String rtype) {
		Rtype = rtype;
	}

	public String getBno() {
		return Bno;
	}

	public void setBno(String bno) {
		Bno = bno;
	}

	public String getRcat() {
		return Rcat;
	}

	public void setRcat(String rcat) {
		Rcat = rcat;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
