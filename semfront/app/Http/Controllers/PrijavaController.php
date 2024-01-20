<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Http\Resources\PrijavaResource;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use App\Models\Prijava;

class PrijavaController extends Controller
{
    public function index()
    {
        $prijava = Prijava::all();
        return PrijavaResource::collection($prijava);
    }

    public function show(Prijava $prijava)
    {
        return new PrijavaResource($prijava);
    }
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'IgracID' => 'required|integer|max:100',
            'TurnirID' => 'required|integer|max:100'
        ]);
        if ($validator->fails()) {
            return response()->json($validator->errors());
        }
        $prijava = Prijava::create([
            'IgracID' => $request->IgracID,
            'TurnirID' => $request->TurnirID

            ,
        ]);
        return response()->json(['Uspesno ste se prijavili!', new PrijavaResource($prijava)]);
    }

    public function destroy(Prijava $prijava)
    {
        $prijava->delete();
        return response()->json('Uspesno izbrisana prijava!');
    }


}