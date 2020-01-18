<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use App\Billet;

class Coupon extends Model
{
    public static function findByCode($code)
    {
        return self::where('code', $code)->first();
    }

    public function discount($total)
    {
        return ($this->reduction / 100) * $total;
    }

    public function getBillet()
    {
        return Billet::where('id', $this->idBillet)->first();
    }
}
