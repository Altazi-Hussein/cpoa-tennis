<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use App\Coupon;

class Billet extends Model
{
    public function coupons(){
        return $this->hasMany(\App\Coupon::class);
    }
}
