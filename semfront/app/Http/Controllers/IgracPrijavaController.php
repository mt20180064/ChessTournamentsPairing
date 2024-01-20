<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use \App\Models\Prijava;
use App\Http\Resources\PrijavaCollection;

class IgracPrijavaController extends Controller
{
    public function index($id)
    {
        $prijave = Prijava::get()->where('IgracID', $id);

        if (count($prijave) == 0) {
            return response()->json('No data!', 404);
        }

        return new PrijavaCollection($prijave);
    }
}