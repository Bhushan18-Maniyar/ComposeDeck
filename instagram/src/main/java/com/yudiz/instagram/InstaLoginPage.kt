package com.yudiz.instagram

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstaLoginPage(
    onLanguageSelectClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier.padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopLoginContent(
            onLanguageSelectClick = onLanguageSelectClick,
            modifier = Modifier.height(30.dp)
        )
        MiddleLoginContent(
            email = email,
            onEmailChange = {
                email = it
            },
            password = password,
            onPassChange = {
                password = it
            },
            loginBtnCLick = {
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .verticalScroll(rememberScrollState())
        )
        BottomLoginContent(
            modifier = Modifier.height(50.dp), onClick = {
                Log.e("TAG", "MiddleLoginContent: Click")
            }
        )
    }
}

@Composable
fun BottomLoginContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(modifier = modifier) {
        Divider(
            modifier = Modifier,
            color = Color.LightGray,
            thickness = 1.dp
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnnotatedClickableText(
                simpleText = "Don't have an account? ",
                clickableText = "Sign up",
                onClick = onClick
            )
        }
    }

}

@Composable
fun MiddleLoginContent(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPassChange: (String) -> Unit,
    loginBtnCLick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_insta_text),
            contentDescription = "Instagram Logo",
            colorFilter = ColorFilter.tint(color = Color(0xFF1B1B1B)),
            modifier = Modifier
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillHeight
        )


        Spacer(modifier = Modifier.height(24.dp))

        LoginEditText(
            modifier = Modifier.fillMaxWidth(),
            text = email,
            onTextChange = onEmailChange,
            isPassword = false,
            placeholder = "Email",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            })
        )

        Spacer(modifier = Modifier.height(18.dp))

        LoginEditText(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onTextChange = onPassChange,
            isPassword = true,
            placeholder = "Password",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                loginBtnCLick.invoke()
            })
        )

        Spacer(modifier = Modifier.height(18.dp))

        InstaLoginButton(
            onClick = {
                loginBtnCLick.invoke()
            },
            text = "Log In",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        AnnotatedClickableText(
            simpleText = "Forgot your login details? ",
            clickableText = "Get help logging in.",
            clickableTextColor = Color(0xFF001597),
            onClick = {
                Log.e("TAG", "MiddleLoginContent: Click")
            })

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = Color.LightGray)
            )

            Text(
                text = "OR",
                modifier = Modifier.padding(horizontal = 10.dp),
                color = Color.Gray
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = Color.LightGray)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook",
                modifier = Modifier.size(22.dp),
            )
            Text(
                text = "Log in with Facebook",
                color = Color(0xFF30a2fa),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun TopLoginContent(
    onLanguageSelectClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onLanguageSelectClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 2.dp)
    ) {
        Text(
            text = "English",
            modifier = Modifier.wrapContentHeight(),
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstaLoginPagePreview() {
    InstaLoginPage(modifier = Modifier.fillMaxSize(), onLanguageSelectClick = {})
}


@Composable
fun LoginEditText(
    modifier: Modifier = Modifier,
    label: String? = null,
    text: String,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    placeholder: String = "",
    isPassword: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    var togglePassword by remember {
        mutableStateOf(true)
    }
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        singleLine = singleLine,
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFF7F7F7),
            focusedBorderColor = Color(0xFF30a2fa),
            unfocusedBorderColor = Color(0xFF969696),
            cursorColor = Color(0xFF30a2fa)
        ),
        visualTransformation = if (isPassword && togglePassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { togglePassword = !togglePassword }) {
                    Icon(
                        painter = if (togglePassword)
                            painterResource(id = R.drawable.ic_pass_visibile_off)
                        else
                            painterResource(id = R.drawable.ic_pass_visible),
                        contentDescription = "Password Toggle"
                    )
                }
            } else {
                trailingIcon?.invoke()
            }
        }
    )
}

@Preview
@Composable
fun LoginEditTextPreview() {
//    LoginEditText()
}

@Composable
fun InstaLoginButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF30a2fa)
        )
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun InstaLoginButtonPreview() {
    InstaLoginButton({}, "Login", Modifier.fillMaxWidth())
}


@Composable
fun AnnotatedClickableText(
    simpleText: String,
    clickableText: String,
    simpleTextColor: Color = Color.Gray,
    clickableTextColor: Color = Color(0xFF002746),
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        //append your initial text
        withStyle(
            style = SpanStyle(
                color = simpleTextColor,
            )
        ) {
            append(simpleText)

        }

        //Start of the pushing annotation which you want to color and make them clickable later
        pushStringAnnotation(
            tag = clickableText,// provide tag which will then be provided when you click the text
            annotation = clickableText
        )
        //add text with your different color/style
        withStyle(
            style = SpanStyle(
                color = clickableTextColor,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(clickableText)
        }
        // when pop is called it means the end of annotation with current tag
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = clickableText,// tag which you used in the buildAnnotatedString
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                //do your stuff when it gets clicked
                onClick.invoke()
            }
        }
    )
}

