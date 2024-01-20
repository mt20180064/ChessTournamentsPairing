<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;
use \App\Http\Resources\KlubResource;

class IgracResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */

    public function toArray(Request $request): array
    {

        return [
            'IgracID' => $this->resource->IgracID,
            'ime' => $this->resource->Ime,
            'prezime' => $this->resource->Prezime,
            'KlubID' => $this->resource->KlubID,
            'kategorija' => $this->resource->Kategorija,
            'rejting' => $this->resource->Rejting,
            'email' => $this->resource->email,
            'password' => $this->resource->password

        ];



    }
}