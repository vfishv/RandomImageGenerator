package com.stedi.randomimagegenerator.generators;

import androidx.annotation.NonNull;

import com.stedi.randomimagegenerator.generators.effects.MirroredEffect;

@Deprecated
public class MirroredGenerator extends MirroredEffect {
    public MirroredGenerator(@NonNull Generator generator) {
        super(generator);
    }
}
