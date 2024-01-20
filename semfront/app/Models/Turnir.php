<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Turnir extends Model
{
    use HasFactory;
    protected $table = 'turnir';
    public $primaryKey = 'TurnirID';
    protected $fillable = [

        'naziv',
        'mesto',
        'tip',
        'tempo',
        'status',
        'slika'
    ];
    public function prijava()
    {
        return $this->belongsTo(Prijava::class);
    }
}