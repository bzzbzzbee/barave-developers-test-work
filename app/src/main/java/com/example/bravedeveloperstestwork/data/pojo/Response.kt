package com.example.bravedeveloperstestwork.data.pojo

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("location_area_encounters")
	val locationAreaEncounters: String? = null,

	@field:SerializedName("types")
	val types: List<TypesItem?>? = null,

	@field:SerializedName("base_experience")
	val baseExperience: Int? = null,

	@field:SerializedName("held_items")
	val heldItems: List<HeldItemsItem?>? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("is_default")
	val isDefault: Boolean? = null,

	@field:SerializedName("sprites")
	val sprites: Sprites? = null,

	@field:SerializedName("abilities")
	val abilities: List<AbilitiesItem?>? = null,

	@field:SerializedName("game_indices")
	val gameIndices: List<GameIndicesItem?>? = null,

	@field:SerializedName("species")
	val species: Species? = null,

	@field:SerializedName("stats")
	val stats: List<StatsItem?>? = null,

	@field:SerializedName("moves")
	val moves: List<MovesItem?>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("forms")
	val forms: List<FormsItem?>? = null,

	@field:SerializedName("height")
	val height: Int? = null,

	@field:SerializedName("order")
	val order: Int? = null
)

data class Other(

	@field:SerializedName("dream_world")
	val dreamWorld: DreamWorld? = null,

	@field:SerializedName("official-artwork")
	val officialArtwork: OfficialArtwork? = null
)

data class Stat(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class GenerationIv(

	@field:SerializedName("platinum")
	val platinum: Platinum? = null,

	@field:SerializedName("diamond-pearl")
	val diamondPearl: DiamondPearl? = null,

	@field:SerializedName("heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilver? = null
)

data class GenerationI(

	@field:SerializedName("yellow")
	val yellow: Yellow? = null,

	@field:SerializedName("red-blue")
	val redBlue: RedBlue? = null
)

data class VersionDetailsItem(

	@field:SerializedName("version")
	val version: Version? = null,

	@field:SerializedName("rarity")
	val rarity: Int? = null
)

data class TypesItem(

	@field:SerializedName("slot")
	val slot: Int? = null,

	@field:SerializedName("type")
	val type: Type? = null
)

data class OfficialArtwork(
	val any: Any? = null
)

data class XY(
	val any: Any? = null
)

data class GenerationViii(

	@field:SerializedName("icons")
	val icons: Icons? = null
)

data class StatsItem(

	@field:SerializedName("stat")
	val stat: Stat? = null,

	@field:SerializedName("base_stat")
	val baseStat: Int? = null,

	@field:SerializedName("effort")
	val effort: Int? = null
)

data class HeldItemsItem(

	@field:SerializedName("item")
	val item: Item? = null,

	@field:SerializedName("version_details")
	val versionDetails: List<VersionDetailsItem?>? = null
)

data class GenerationIii(

	@field:SerializedName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreen? = null,

	@field:SerializedName("ruby-sapphire")
	val rubySapphire: RubySapphire? = null,

	@field:SerializedName("emerald")
	val emerald: Emerald? = null
)

data class VersionGroupDetailsItem(

	@field:SerializedName("level_learned_at")
	val levelLearnedAt: Int? = null,

	@field:SerializedName("version_group")
	val versionGroup: VersionGroup? = null,

	@field:SerializedName("move_learn_method")
	val moveLearnMethod: MoveLearnMethod? = null
)

data class Sprites(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: String? = null,

	@field:SerializedName("back_female")
	val backFemale: String? = null,

	@field:SerializedName("other")
	val other: Other? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("versions")
	val versions: Versions? = null,

	@field:SerializedName("front_female")
	val frontFemale: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class Emerald(
	val any: Any? = null
)

data class GenerationVi(

	@field:SerializedName("omegaruby-alphasapphire")
	val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,

	@field:SerializedName("x-y")
	val xY: XY? = null
)

data class Ability(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String? = null
)

data class VersionGroup(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Item(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Version(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class MoveLearnMethod(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Silver(
	val any: Any? = null
)

data class RubySapphire(
	val any: Any? = null
)

data class HeartgoldSoulsilver(
	val any: Any? = null
)

data class Type(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Versions(

	@field:SerializedName("generation-iii")
	val generationIii: GenerationIii? = null,

	@field:SerializedName("generation-ii")
	val generationIi: GenerationIi? = null,

	@field:SerializedName("generation-v")
	val generationV: GenerationV? = null,

	@field:SerializedName("generation-iv")
	val generationIv: GenerationIv? = null,

	@field:SerializedName("generation-vii")
	val generationVii: GenerationVii? = null,

	@field:SerializedName("generation-i")
	val generationI: GenerationI? = null,

	@field:SerializedName("generation-viii")
	val generationViii: GenerationViii? = null,

	@field:SerializedName("generation-vi")
	val generationVi: GenerationVi? = null
)

data class Yellow(
	val any: Any? = null
)

data class GenerationV(

	@field:SerializedName("black-white")
	val blackWhite: BlackWhite? = null
)

data class OmegarubyAlphasapphire(
	val any: Any? = null
)

data class UltraSunUltraMoon(
	val any: Any? = null
)

data class DiamondPearl(
	val any: Any? = null
)

data class GenerationVii(

	@field:SerializedName("icons")
	val icons: Icons? = null,

	@field:SerializedName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: UltraSunUltraMoon? = null
)

data class GenerationIi(

	@field:SerializedName("gold")
	val gold: Gold? = null,

	@field:SerializedName("crystal")
	val crystal: Crystal? = null,

	@field:SerializedName("silver")
	val silver: Silver? = null
)

data class Species(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Move(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Gold(
	val any: Any? = null
)

data class Platinum(
	val any: Any? = null
)

data class DreamWorld(
	val any: Any? = null
)

data class BlackWhite(
	val any: Any? = null
)

data class Crystal(
	val any: Any? = null
)

data class RedBlue(
	val any: Any? = null
)

data class FormsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Icons(
	val any: Any? = null
)

data class MovesItem(

	@field:SerializedName("version_group_details")
	val versionGroupDetails: List<VersionGroupDetailsItem?>? = null,

	@field:SerializedName("move")
	val move: Move? = null
)

data class AbilitiesItem(

	@field:SerializedName("is_hidden")
	val isHidden: Boolean? = null,

	@field:SerializedName("slot")
	val slot: Int? = null,

	@field:SerializedName("ability")
	val ability: Ability? = null
)

data class GameIndicesItem(

	@field:SerializedName("game_index")
	val gameIndex: Int? = null,

	@field:SerializedName("version")
	val version: Version? = null
)

data class FireredLeafgreen(
	val any: Any? = null
)
