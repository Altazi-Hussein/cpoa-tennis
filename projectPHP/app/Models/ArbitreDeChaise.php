<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class ArbitreDeChaise
 * 
 * @property int $idArbitreC
 * @property int $nbMatchSimple
 * @property int $nbMatchDouble
 * 
 * @property Arbitre $arbitre
 *
 * @package App\Models
 */
class ArbitreDeChaise extends Model
{
	protected $table = 'ArbitreDeChaise';
	protected $primaryKey = 'idArbitreC';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idArbitreC' => 'int',
		'nbMatchSimple' => 'int',
		'nbMatchDouble' => 'int'
	];

	protected $fillable = [
		'nbMatchSimple',
		'nbMatchDouble'
	];

	public function arbitre()
	{
		return $this->belongsTo(Arbitre::class, 'idArbitreC');
	}
}
