package io.sunstrike.corestrike.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class CorestrikeLoader implements IFMLLoadingPlugin {

	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {"io.sunstrike.corestrike.asm.ASMTransformer"};
	}

	@Override
	public String getModContainerClass() {
		return "io.sunstrike.corestrike.CorestrikeLib";
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		return;
	}

}
