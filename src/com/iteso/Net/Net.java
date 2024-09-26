package com.iteso.Net;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Net {
	protected InetAddress ip;
	protected int port;
	protected String protocol;
	private boolean versionIp; // 1 = IPv4 && 0 = IPv6
	
	public Net() {
		try {
			this.ip = InetAddress.getLocalHost();
			this.port = 65535;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public Net(String ip) {
			setIp(ip);
	}
	public Net(String ip, int port) {
		String protocol = "";
		setNetInfo(ip, port, protocol);
	}
	public Net(String ip, int port, String protocol) {
		setNetInfo(ip, port, protocol);
	}
	
	private boolean ValidateIp(String ip) {
		try {
			InetAddress address = InetAddress.getByName(ip);
			if(address instanceof Inet4Address) return true;
			else return false;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void setNetInfo(String ip, int port, String protocol) {
		setIp(ip);
		setPort(port);
		setProtocol(protocol);
	}
	
	public void setIp(String ip) {
		if(ValidateIp(ip)) {
			InetAddress address;
			try {
				address = InetAddress.getByName(ip);
				this.ip = (InetAddress) address;
				this.versionIp = true; 
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		} else {
			InetAddress address;
			try {
				address = InetAddress.getByName(ip);
				this.ip = (InetAddress) address;
				this.versionIp = false; 
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setPort(int port) {
		if(port > 0 && port >= 65535) this.port = port;
	}
	
	public void setProtocol(String protocol) {
		boolean flag;
		try {
			protocol.toString();
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		if (flag) {
			this.protocol = protocol.trim().toLowerCase();
		}
	}
	
	public int getVersionIp() {
		if (this.versionIp) {
			return 4;
		} else {
			return 6;
		}
	}
	
}
