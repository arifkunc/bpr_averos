package net.plaut.bprtab.tesmvc;

public class ControllerMVC {
	private ModelMVC modelMVC;
	private FrameMVC frameMVC;
	
	ControllerMVC(FrameMVC frameMVC, ModelMVC modelMVC){
		this.frameMVC = frameMVC;
		this.modelMVC = modelMVC;
	}
	
	public void setArah(String string){
		modelMVC.setArah(string);
		frameMVC.getLbArah().setText(string);
	}
}
