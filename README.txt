####LICENSE####

1. You are free to use any content of this repository for your own personal
guidance and/or learning.

2. You may not directly copy this repository or anything residing within
the repository, or post any projects to either the bukkit forums, github or
any other places (including servers themselves) without recieving consent
from me.

3. You may study this source code for the purpose of finding API functions
among other things

####API####

The api for ProBlockGaurd is rather simple, to use it in your projects:

Add the ProBlockGaurd.jar as a dependancy to your project

Import 'me.wizzledonker.plugins.problockgaurd.api.PBGapi'

You may then make a function to check if the plugin is initialised on the server,
if it isn't, then disable the plugin.

//CODE//
private boolean setupPBG() {
	Plugin PBG = this.getServer().getPluginManager().getPlugin("ProBlockGaurd");
	if (PBG == null) {
		return false;
	}
	return true;
}
//CODE//

And in your onEnable:

//CODE//

public void onEnable() {
	if (!setupPBG()) {
		System.out.println(this + ": PBG not found! Disabling plugin...")
		this.getServer().getPluginManager().disablePlugin(this);
	}
	System.out.println(this + " has been successfully enabled on server!")
}
//CODE//

At the start of any class you want to use PBG:

//CODE//

private PBGapi pbg = new PBGapi();

//CODE//

and when you want to use any function of PBG, just use:

pbg.

And find functions using intellisense!


I reccomend you use only the API I have provided rather than using the
main class or something because I constantly change this... and I always
make sure the API will stay the same, so your plugins for PBG will never
get broken if you only use the API.

-WizzleDonker