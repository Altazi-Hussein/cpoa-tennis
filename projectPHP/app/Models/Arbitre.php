<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class Arbitre
 * 
 * @property int $idArbitre
 * @property string $nom
 * @property string $prenom
 * @property string $nationalite
 * @property string $categorie
 * 
 * @property ArbitreDeChaise $arbitre_de_chaise
 * @property ArbitreDeLigne $arbitre_de_ligne
 *
 * @package App\Models
 */
class Arbitre extends Model
{
	protected $table = 'Arbitre';
	protected $primaryKey = 'idArbitre';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idArbitre' => 'int'
	];

	protected $fillable = [
		'nom',
		'prenom',
		'nationalite',
		'categorie'
	];

	public function arbitre_de_chaise()
	{
		return $this->hasOne(ArbitreDeChaise::class, 'idArbitreC');
	}

	public function arbitre_de_ligne()
	{
		return $this->hasOne(ArbitreDeLigne::class, 'idArbitreL');
	}
}
