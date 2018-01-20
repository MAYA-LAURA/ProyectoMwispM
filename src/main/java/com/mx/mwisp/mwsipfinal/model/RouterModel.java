package com.mx.mwisp.mwsipfinal.model;

import java.io.Serializable;

public class RouterModel implements Serializable {
	private static final long serialVersionUID = -760192321438766969L;//si lago sale mal es aqui :D
	private int idRouter;
	private String nombreRouter;
	private String ipODnsRouter;
	private String userRouter;
	private String passRouter;
	private String UbicacionRouter;
	
	public RouterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RouterModel(String nombreRouter, String ipODnsRouter, String userRouter, String passRouter,
			String ubicacionRouter) {
		super();
		this.nombreRouter = nombreRouter;
		this.ipODnsRouter = ipODnsRouter;
		this.userRouter = userRouter;
		this.passRouter = passRouter;
		UbicacionRouter = ubicacionRouter;
	}

	public RouterModel(int idRouter, String nombreRouter, String ipODnsRouter, String userRouter, String passRouter,
			String ubicacionRouter) {
		super();
		this.idRouter = idRouter;
		this.nombreRouter = nombreRouter;
		this.ipODnsRouter = ipODnsRouter;
		this.userRouter = userRouter;
		this.passRouter = passRouter;
		UbicacionRouter = ubicacionRouter;
	}

	public int getIdRouter() {
		return idRouter;
	}

	public void setIdRouter(int idRouter) {
		this.idRouter = idRouter;
	}

	public String getNombreRouter() {
		return nombreRouter;
	}

	public void setNombreRouter(String nombreRouter) {
		this.nombreRouter = nombreRouter;
	}

	public String getIpODnsRouter() {
		return ipODnsRouter;
	}

	public void setIpODnsRouter(String ipODnsRouter) {
		this.ipODnsRouter = ipODnsRouter;
	}

	public String getUserRouter() {
		return userRouter;
	}

	public void setUserRouter(String userRouter) {
		this.userRouter = userRouter;
	}

	public String getPassRouter() {
		return passRouter;
	}

	public void setPassRouter(String passRouter) {
		this.passRouter = passRouter;
	}

	public String getUbicacionRouter() {
		return UbicacionRouter;
	}

	public void setUbicacionRouter(String ubicacionRouter) {
		UbicacionRouter = ubicacionRouter;
	}

	@Override
	public String toString() {
		return "DTORouter [idRouter=" + idRouter + ", nombreRouter=" + nombreRouter + ", ipODnsRouter=" + ipODnsRouter
				+ ", userRouter=" + userRouter + ", passRouter=" + passRouter + ", UbicacionRouter=" + UbicacionRouter
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UbicacionRouter == null) ? 0 : UbicacionRouter.hashCode());
		result = prime * result + idRouter;
		result = prime * result + ((ipODnsRouter == null) ? 0 : ipODnsRouter.hashCode());
		result = prime * result + ((nombreRouter == null) ? 0 : nombreRouter.hashCode());
		result = prime * result + ((passRouter == null) ? 0 : passRouter.hashCode());
		result = prime * result + ((userRouter == null) ? 0 : userRouter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RouterModel other = (RouterModel) obj;
		if (UbicacionRouter == null) {
			if (other.UbicacionRouter != null)
				return false;
		} else if (!UbicacionRouter.equals(other.UbicacionRouter))
			return false;
		if (idRouter != other.idRouter)
			return false;
		if (ipODnsRouter == null) {
			if (other.ipODnsRouter != null)
				return false;
		} else if (!ipODnsRouter.equals(other.ipODnsRouter))
			return false;
		if (nombreRouter == null) {
			if (other.nombreRouter != null)
				return false;
		} else if (!nombreRouter.equals(other.nombreRouter))
			return false;
		if (passRouter == null) {
			if (other.passRouter != null)
				return false;
		} else if (!passRouter.equals(other.passRouter))
			return false;
		if (userRouter == null) {
			if (other.userRouter != null)
				return false;
		} else if (!userRouter.equals(other.userRouter))
			return false;
		return true;
	}
}
