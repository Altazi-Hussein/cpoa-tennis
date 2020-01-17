<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class ArbitreDeLigne
 * 
 * @property int $idArbitreL
 * @property int $idEquipeL
 * 
 * @property Arbitre $arbitre
 *
 * @package App\Models
 */
class ArbitreDeLigne extends Model
{
	protected $table = 'ArbitreDeLigne';
	protected $primaryKey = 'idArbitreL';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idArbitreL' => 'int',
		'idEquipeL' => 'int'
	];

	protected $fillable = [
		'idEquipeL'
	];

	public function arbitre()
	{
		return $this->belongsTo(Arbitre::class, 'idArbitreL');
	}
}
