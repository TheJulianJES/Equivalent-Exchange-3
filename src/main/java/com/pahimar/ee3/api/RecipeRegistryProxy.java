package com.pahimar.ee3.api;

import com.pahimar.ee3.EquivalentExchange3;
import cpw.mods.fml.common.Mod;

import java.util.List;

public class RecipeRegistryProxy
{
    public static void addRecipe(Object recipeOutput, List<?> recipeInputList)
    {
        init();

        // NOOP if EquivalentExchange3 is not present
        if (ee3Mod == null)
        {
            return;
        }

        EE3Wrapper.ee3mod.getRecipeRegistry().addRecipe(recipeOutput, recipeInputList);
    }

    @Mod.Instance("EE3")
    private static Object ee3Mod;

    private static class EE3Wrapper
    {
        private static EquivalentExchange3 ee3mod;
    }

    private static void init()
    {
        if (ee3Mod != null)
        {
            EE3Wrapper.ee3mod = (EquivalentExchange3) ee3Mod;
        }
    }
}
