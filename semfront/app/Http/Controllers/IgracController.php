<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Http\Resources\IgracResource;
use App\Models\Igrac;
use Illuminate\Http\Request;

class IgracController extends Controller
{
    public function index()
    {
        $igrac = Igrac::all();
        return IgracResource::collection($igrac);
    }

    public function show(Igrac $igrac)
    {
        return new IgracResource($igrac);
    }

    public function store(Request $request)
    {
        $igrac = Igrac::create([
            'ime' => $request->ime,
            'prezime' => $request->prezime,
            'klub' => $request->klub,
            'kategorija' => $request->kategorija,
            'rejting' => $request->rejting,
            'password' => $request->password,
            'email' => $request->email

        ]);

        $igrac->save();

        return response()->json(['Igrac je uspesno kreiran.', new IgracResource($igrac), 'success' => true]);
    }
}