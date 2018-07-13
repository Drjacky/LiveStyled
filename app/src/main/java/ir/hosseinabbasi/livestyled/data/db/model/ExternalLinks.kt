package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ExternalLinks(

	@field:SerializedName("youtube")
	val youtube: List<YoutubeItem?>? = null,

	@field:SerializedName("twitter")
	val twitter: List<TwitterItem?>? = null,

	@field:SerializedName("facebook")
	val facebook: List<FacebookItem?>? = null,

	@field:SerializedName("instagram")
	val instagram: List<InstagramItem?>? = null,

	@field:SerializedName("musicbrainz")
	val musicbrainz: List<MusicbrainzItem?>? = null
)