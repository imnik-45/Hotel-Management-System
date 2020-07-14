package Pack1;

import java.io.Serializable;

	public class new_info implements Serializable {
		private static final long serialVersionUID = 1L;

		
		private String password;
		private String chkin;
		private String chkout;
		private String net;
		private String intr; 
		public String rt;
	   
		
		public  new_info(String chkin,String chkout,String net,String intr,String rt )
		{
			super();
		    //this.id = id;
	        this.intr=intr;
			this.chkin=chkin;
			this.chkout=chkout;
			this.net=net;
			this.rt=rt;
			
		}
		public String getChkin() {
			return chkin;
		}

		public void setChkin(String chkin) {
			this.chkin = chkin;
		}

		public String getChkout() {
			return chkout;
		}

		public void setChkout(String chkout) {
			this.chkout = chkout;
		}

		public String getNet() {
			return net;
		}

		public void setNet(String net) {
			this.net = net;
		}
		 public String getIntr() {
				return intr;
			}
			public void setIntr(String intr) {
				this.intr =intr;
			}


	/*	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
*/
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRt() {
			return rt;
		}
		public void setRt(String rt) {
			this.rt = rt;
		}
	}

