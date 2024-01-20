<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Http\Resources\TurnirResource;
use App\Models\Igrac;
use App\Models\Prijava;
use App\Models\Turnir;
use Illuminate\Http\Request;

class IgracTurniriController extends Controller
{
    public function index($id)
    {

        if (isset($id)) {
            $prijave = Prijava::get()->where('IgracID', $id);

            if (count($prijave) == 0) {
                return response()->json('No data!', 404);
            }

            foreach ($prijave as $prij) {
                $prij['turnir'] = Turnir::get()->where('TurnirID', $prij['TurnirID'])[strval($prij['TurnirID'] - 1)];
            }
            dd($prijave);
            dd($id);

            return $prijave;
        }
    }
}