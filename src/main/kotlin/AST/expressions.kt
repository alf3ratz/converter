// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.nj2k

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.nj2k.tree.*

val JKElement.psi: PsiElement?
    get() = (this as? PsiOwner)?.psi

inline fun <reified Elem : PsiElement> JKElement.psi(): Elem? = (this as? PsiOwner)?.psi as? Elem
