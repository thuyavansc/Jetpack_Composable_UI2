package au.com.softclient.jetpack_composable_ui2.ui

//import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.changelist.Operation.MoveCurrentGroup.Offset
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import au.com.softclient.jetpack_composable_ui2.Feature
import au.com.softclient.jetpack_composable_ui2.R
import au.com.softclient.jetpack_composable_ui2.ui.theme.Beige1
import au.com.softclient.jetpack_composable_ui2.ui.theme.Beige2
import au.com.softclient.jetpack_composable_ui2.ui.theme.Beige3
import au.com.softclient.jetpack_composable_ui2.ui.theme.BlueViolet1
import au.com.softclient.jetpack_composable_ui2.ui.theme.BlueViolet2
import au.com.softclient.jetpack_composable_ui2.ui.theme.BlueViolet3
import au.com.softclient.jetpack_composable_ui2.ui.theme.ButtonBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.DarkerButtonBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.DeepBlue
import au.com.softclient.jetpack_composable_ui2.ui.theme.LightGreen1
import au.com.softclient.jetpack_composable_ui2.ui.theme.LightGreen2
import au.com.softclient.jetpack_composable_ui2.ui.theme.LightGreen3
import au.com.softclient.jetpack_composable_ui2.ui.theme.LightRed
import au.com.softclient.jetpack_composable_ui2.ui.theme.OrangeYellow1
import au.com.softclient.jetpack_composable_ui2.ui.theme.OrangeYellow2
import au.com.softclient.jetpack_composable_ui2.ui.theme.OrangeYellow3
import au.com.softclient.jetpack_composable_ui2.ui.theme.TextWhite
import standardQuadFromTo

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            GreetingSection();
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Type X1", "Type X2", "Type X3"));
            CurrentMeditation();
            FeatureSection(features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        Icons.Default.CheckCircle,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        Icons.Default.Notifications,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        Icons.Default.Home,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        Icons.Default.Lock,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )

        }
    }
}



//Section-1
@Composable
fun GreetingSection(
    name: String = "Pure"
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ){
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(text="Good Morning, $name",
                style = MaterialTheme.typography.headlineSmall,
                );
            Text(
                text = "we wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium
            )
        };
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        );
    }
}

//Section 2 - Lazy Row
@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember{
        mutableStateOf( 0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }

        }

    }
}


//Section - 3
@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(text="Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
            );
            Text(
                text = "Meditation * 3 - 10 Min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        };
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            );

        }

    }

}

//Section - 4
@Composable
fun FeatureSection(features: List<Feature>){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp),
            )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight(),
            content = {
                items(features.size){
                    FeatureItem(feature = features[it])

                }
            }
        )

    }

}

@Composable
fun FeatureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth;
        val height = constraints.maxHeight;

        //Medium Colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f);
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        //Drawing path in Canvas
        Canvas(
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = "Canvas Drawing",
            onDraw = {
                drawPath(
                    path = mediumColoredPath,
                    color = feature.mediumColor
                )
                drawPath(
                    path = lightColoredPath,
                    color = feature.lightColor
                )
            }

        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                imageVector = feature.icon,
                contentDescription = "check",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //Handle the Click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}