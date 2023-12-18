<h2>Configurable Mob Potion Effects</h2>
<p><a href="https://github.com/Serilum/Configurable-Mob-Potion-Effects"><img src="https://serilum.com/assets/data/logo/configurable-mob-potion-effects.png"></a></p><h2>Download</h2>
<p>You can download Configurable Mob Potion Effects on CurseForge and Modrinth:</p><p>&nbsp;&nbsp;CurseForge: &nbsp;&nbsp;<a href="https://curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects">https://curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects</a><br>&nbsp;&nbsp;Modrinth: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://modrinth.com/mod/configurable-mob-potion-effects">https://modrinth.com/mod/configurable-mob-potion-effects</a></p>
<h2>Issue Tracker</h2>
<p>To keep a better overview of all mods, the issue tracker is located in a separate repository.<br>&nbsp;&nbsp;For issues, ideas, suggestions or anything else, please follow this link:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/issue-tracker">Issue Tracker</a></p>
<h2>Pull Requests</h2>
<p>Because of the way mod loader files are bundled into one jar, some extra information is needed to do a PR.<br>&nbsp;&nbsp;A wiki page entry about it is available here:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/pull-requests">Pull Request Information</a></p>
<h2>Mod Description</h2>
<p><a href="https://serilum.com/" rel="nofollow"><img src="https://github.com/Serilum/.cdn/blob/main/description/header/header.png" alt="" width="838" height="400"></a><br><br><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/header.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:75125" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_20.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:73407" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_19.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:73250" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_18.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:73242" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_17.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:70886" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_16.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:68722" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_15.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/configurable-mob-potion-effects/files/all?filter-status=1&filter-game-version=1738749986:64806" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_14.png"></a><br><br><strong><span style="font-size:24px">Requires the library mod&nbsp;<a style="font-size:24px" href="https://www.curseforge.com/minecraft/mc-mods/collective" rel="nofollow">Collective</a>.<br></span></strong></p>
<p><span style="font-size:18px">Configurable Mob Potion Effects is a server-side mod which allows administrators to give any mob a permanent potion effect and set a potion effect done to the target when a mob damages them. It is completely configurable, it works for all modded entities and all modded potion effects. The mod by default does not do anything, you have the control.<br><br>There are two config files. Both located in the folder '<em>./config/configurablemobpotioneffects/</em>'.<br>One is called '<em>permanenteffects.txt</em>'. Here you can add permanent potion effects to any mob.<br>The other is called 'o<em>ndamageeffects.txt</em>'. Here you can set what potion effects should be given to the damaged target by any mob.<br><br>The config files are generated on first load of the mod. If you add any modded entities or potion effects, remove the files and reload the game once.<br></span><br><br><span style="font-size:24px"><strong>Commands:</strong></span><br><span style="font-size:14px"><em>/cmpe reload</em> - Reloads all manual changes to the config files.<br><span style="font-size:12px"><br></span><br></span></p>
<p><span style="font-size:14px"><span style="font-size:24px"><strong>The Config Files:</strong></span><br><span style="font-size:18px"><span style="font-size:14px">After first load, the config files contain all possible entities and all possible potion effects. With the level set to 0, all are disabled by default. All you have to do is find the correct line and change the values.<br></span><br>The '<em>permanenteffects.txt</em>' config file:</span><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/a.png" width="1142" height="167"></picture><br><span style="font-size:18px"><br>The '<em>ondamageeffects.txt</em>' config file:</span><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/b.png" width="1142" height="214"></picture><br></span><br><br><br><span style="font-size:24px"><strong>Examples:</strong></span><br><span style="font-size:18px">Let's make all slimes super fast, with a permanent speed level of 50.</span><br><br><strong>Find the slime section in '<em>./config/configurablemobpotioneffects/permanenteffects.txt</em>':</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/c.png" width="1142" height="126"></picture><br><br><strong>Find the speed potion effect section:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/d.png" width="1142" height="125"></picture><br><br><strong>Set the level to 50:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/e.png" width="1142" height="125"></picture><br><br><strong>Restart the game or use <em>/cmpe reload</em> and watch the magic happen:</strong></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/f.gif" width="1000" height="560"></picture></p>
</div>
<p>&nbsp;</p>
<p><br><br><span style="font-size:18px">Another example, let's make the endermite's attack give levitation 10 for 1 second.</span><br><br><strong>Find the endermite in '<em>./config/configurablemobpotioneffects/ondamageeffects.txt</em>':</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/g.png" width="1356" height="189"></picture><br><br><strong>Find the levitation section:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/h.png" width="1142" height="156"></picture><br><br><strong>Set levitation level to 10:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/i.png" width="1142" height="156"></picture><br><br><strong>Set the duration to 1 second:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/j.png" width="1142" height="155"></picture><br><br><strong>Restart the game or use <em>/cmpe reload</em> and let's fight that endermite!</strong></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/k.gif" width="1000" height="564"></picture></p>
</div>
<p>&nbsp;</p>
<p><br><span style="font-size:18px">Last example, let's make a zombie quite fast and poison its target when it attacks:</span><br><br><strong>Find the zombie in '<em>permanenteffects.txt</em>', and set the speed level to 5:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/l.png" width="1142" height="124"></picture><br><br><strong>Find the zombie section in '<em>ondamageeffects.txt</em>' and set the poison level to 2, the duration of 5 seconds is fine:</strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/m.png" width="1142" height="154"></picture><br><br><strong>Restart the game or use <em>/cmpe reload</em> and done! Here's the zombie:</strong></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/configurable-mob-potion-effects/n.gif"></picture></p>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><span style="font-size:24px"><strong>Your turn! :)</strong></span></p>
<p><br>------------------<br><br><span style="font-size:24px"><strong>You may freely use this mod in any modpack, as long as the download remains hosted within the CurseForge or Modrinth ecosystem.</strong></span><br><br><span style="font-size:18px"><a style="font-size:18px;color:#008000" href="https://serilum.com/" rel="nofollow">Serilum.com</a> contains an overview and more information on all mods available.</span><br><br><span style="font-size:14px">Comments are disabled as I'm unable to keep track of all the separate pages on each mod.</span><span style="font-size:14px"><br>For issues, ideas, suggestions or anything else there is the&nbsp;<a style="font-size:14px;color:#008000" href="https://serilum.com/url/issue-tracker" rel="nofollow">Github repo</a>. Thanks!</span><span style="font-size:6px"><br><br></span><a href="https://ricksouth.com/donate" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/shields/donation_rounded.svg" alt="" width="306" height="50"></a></p>