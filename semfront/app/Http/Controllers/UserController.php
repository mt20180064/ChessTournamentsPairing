<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use App\Http\Resources\UserCollection;
use App\Http\Resources\UserResource;

class UserController extends Controller
{

    public function index()
    {
        return new UserCollection(User::all());
    }






    public function show(User $user)
    {
        return new UserResource($user);
    }


    public function edit(User $user)
    {
        //
    }


    public function update(Request $request, User $user)
    {
        if ($request->name != null && $request->email != null) {
            $user->name = $request->name;
            $user->email = $request->email;
        }
        if ($request->name != null && $request->email == null) {
            $user->name = $request->name;
        }
        if ($request->name == null && $request->email != null) {
            $user->email = $request->email;
        }

        $user->save();

        return response()->json(['User is updated successfully!', new UserResource($user)]);
    }


    public function destroy(User $user)
    {
        //
    }
}