package com.example.coronavirusglobalcases;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> implements Filterable{

    String json = "{\"code\":200,\"result\":[{\"name\":\"Andorra\",\"code\":\"AD\",\"states\":null},{\"name\":\"UAE\",\"code\":\"AE\",\"states\":null},{\"name\":\"Afghanistan\",\"code\":\"AF\",\"states\":null},{\"name\":\"Antigua and Barbuda\",\"code\":\"AG\",\"states\":null},{\"name\":\"Anguilla\",\"code\":\"AI\",\"states\":null},{\"name\":\"Albania\",\"code\":\"AL\",\"states\":null},{\"name\":\"Armenia\",\"code\":\"AM\",\"states\":null},{\"name\":\"Netherlands Antilles\",\"code\":\"AN\",\"states\":null},{\"name\":\"Angola\",\"code\":\"AO\",\"states\":null},{\"name\":\"Antarctica\",\"code\":\"AQ\",\"states\":null},{\"name\":\"Argentina\",\"code\":\"AR\",\"states\":null},{\"name\":\"American Samoa\",\"code\":\"AS\",\"states\":null},{\"name\":\"Austria\",\"code\":\"AT\",\"states\":null},{\"name\":\"Australia\",\"code\":\"AU\",\"states\":[{\"code\":\"ACT\",\"name\":\"Australian Capital Territory\"},{\"code\":\"NSW\",\"name\":\"New South Wales\"},{\"code\":\"NT\",\"name\":\"Northern Territory\"},{\"code\":\"QLD\",\"name\":\"Queensland\"},{\"code\":\"SA\",\"name\":\"South Australia\"},{\"code\":\"TAS\",\"name\":\"Tasmania\"},{\"code\":\"VIC\",\"name\":\"Victoria\"},{\"code\":\"WA\",\"name\":\"Western Australia\"}]},{\"name\":\"Aruba\",\"code\":\"AW\",\"states\":null},{\"name\":\"Azerbaijan\",\"code\":\"AZ\",\"states\":null},{\"name\":\"Bosnia and Herzegovina\",\"code\":\"BA\",\"states\":null},{\"name\":\"Barbados\",\"code\":\"BB\",\"states\":null},{\"name\":\"Bangladesh\",\"code\":\"BD\",\"states\":null},{\"name\":\"Belgium\",\"code\":\"BE\",\"states\":null},{\"name\":\"Burkina Faso\",\"code\":\"BF\",\"states\":null},{\"name\":\"Bulgaria\",\"code\":\"BG\",\"states\":null},{\"name\":\"Bahrain\",\"code\":\"BH\",\"states\":null},{\"name\":\"Burundi\",\"code\":\"BI\",\"states\":null},{\"name\":\"Benin\",\"code\":\"BJ\",\"states\":null},{\"name\":\"Bermuda\",\"code\":\"BM\",\"states\":null},{\"name\":\"Brunei\",\"code\":\"BN\",\"states\":null},{\"name\":\"Bolivia\",\"code\":\"BO\",\"states\":null},{\"name\":\"Brazil\",\"code\":\"BR\",\"states\":null},{\"name\":\"Bahamas\",\"code\":\"BS\",\"states\":null},{\"name\":\"Bhutan\",\"code\":\"BT\",\"states\":null},{\"name\":\"Bouvet Island\",\"code\":\"BV\",\"states\":null},{\"name\":\"Botswana\",\"code\":\"BW\",\"states\":null},{\"name\":\"Belarus\",\"code\":\"BY\",\"states\":null},{\"name\":\"Belize\",\"code\":\"BZ\",\"states\":null},{\"name\":\"Canada\",\"code\":\"CA\",\"states\":[{\"code\":\"AB\",\"name\":\"Alberta\"},{\"code\":\"BC\",\"name\":\"British Columbia\"},{\"code\":\"MB\",\"name\":\"Manitoba\"},{\"code\":\"NB\",\"name\":\"New Brunswick\"},{\"code\":\"NL\",\"name\":\"Newfoundland and Labrador\"},{\"code\":\"NS\",\"name\":\"Nova Scotia\"},{\"code\":\"NT\",\"name\":\"Northwest Territories\"},{\"code\":\"NU\",\"name\":\"Nunavut\"},{\"code\":\"ON\",\"name\":\"Ontario\"},{\"code\":\"PE\",\"name\":\"Prince Edward Island\"},{\"code\":\"QC\",\"name\":\"Quebec\"},{\"code\":\"SK\",\"name\":\"Saskatchewan\"},{\"code\":\"YT\",\"name\":\"Yukon\"}]},{\"name\":\"Cocos (Keeling) Islands\",\"code\":\"CC\",\"states\":null},{\"name\":\"Congo, the Democratic Republic of the\",\"code\":\"CD\",\"states\":null},{\"name\":\"Central African Republic\",\"code\":\"CF\",\"states\":null},{\"name\":\"Congo\",\"code\":\"CG\",\"states\":null},{\"name\":\"Switzerland\",\"code\":\"CH\",\"states\":null},{\"name\":\"ivory cost\",\"code\":\"CI\",\"states\":null},{\"name\":\"Cook Islands\",\"code\":\"CK\",\"states\":null},{\"name\":\"Chile\",\"code\":\"CL\",\"states\":null},{\"name\":\"Cameroon\",\"code\":\"CM\",\"states\":null},{\"name\":\"China\",\"code\":\"CN\",\"states\":null},{\"name\":\"Colombia\",\"code\":\"CO\",\"states\":null},{\"name\":\"Costa Rica\",\"code\":\"CR\",\"states\":null},{\"name\":\"Cuba\",\"code\":\"CU\",\"states\":null},{\"name\":\"Cape Verde\",\"code\":\"CV\",\"states\":null},{\"name\":\"Curacao\",\"code\":\"CW\",\"states\":null},{\"name\":\"Christmas Island\",\"code\":\"CX\",\"states\":null},{\"name\":\"Cyprus\",\"code\":\"CY\",\"states\":null},{\"name\":\"Czechia\",\"code\":\"CZ\",\"states\":null},{\"name\":\"Germany\",\"code\":\"DE\",\"states\":null},{\"name\":\"Djibouti\",\"code\":\"DJ\",\"states\":null},{\"name\":\"Denmark\",\"code\":\"DK\",\"states\":null},{\"name\":\"Dominica\",\"code\":\"DM\",\"states\":null},{\"name\":\"Dominican Republic\",\"code\":\"DO\",\"states\":null},{\"name\":\"Algeria\",\"code\":\"DZ\",\"states\":null},{\"name\":\"Ecuador\",\"code\":\"EC\",\"states\":null},{\"name\":\"Estonia\",\"code\":\"EE\",\"states\":null},{\"name\":\"Egypt\",\"code\":\"EG\",\"states\":null},{\"name\":\"Western Sahara\",\"code\":\"EH\",\"states\":null},{\"name\":\"Eritrea\",\"code\":\"ER\",\"states\":null},{\"name\":\"Spain\",\"code\":\"ES\",\"states\":null},{\"name\":\"Ethiopia\",\"code\":\"ET\",\"states\":null},{\"name\":\"Finland\",\"code\":\"FI\",\"states\":null},{\"name\":\"Fiji\",\"code\":\"FJ\",\"states\":null},{\"name\":\"Falkland Islands (Malvinas)\",\"code\":\"FK\",\"states\":null},{\"name\":\"Micronesia, Federated States of\",\"code\":\"FM\",\"states\":null},{\"name\":\"Faroe Islands\",\"code\":\"FO\",\"states\":null},{\"name\":\"France\",\"code\":\"FR\",\"states\":null},{\"name\":\"Gabon\",\"code\":\"GA\",\"states\":null},{\"name\":\"uk\",\"code\":\"GB\",\"states\":null},{\"name\":\"Grenada\",\"code\":\"GD\",\"states\":null},{\"name\":\"Georgia\",\"code\":\"GE\",\"states\":null},{\"name\":\"French Guiana\",\"code\":\"GF\",\"states\":null},{\"name\":\"Guernsey\",\"code\":\"GG\",\"states\":null},{\"name\":\"Ghana\",\"code\":\"GH\",\"states\":null},{\"name\":\"Gibraltar\",\"code\":\"GI\",\"states\":null},{\"name\":\"Greenland\",\"code\":\"GL\",\"states\":null},{\"name\":\"Gambia\",\"code\":\"GM\",\"states\":null},{\"name\":\"Guinea\",\"code\":\"GN\",\"states\":null},{\"name\":\"Guadeloupe\",\"code\":\"GP\",\"states\":null},{\"name\":\"Equatorial Guinea\",\"code\":\"GQ\",\"states\":null},{\"name\":\"Greece\",\"code\":\"GR\",\"states\":null},{\"name\":\"South Georgia and the South Sandwich Islands\",\"code\":\"GS\",\"states\":null},{\"name\":\"Guatemala\",\"code\":\"GT\",\"states\":null},{\"name\":\"Guam\",\"code\":\"GU\",\"states\":null},{\"name\":\"Guinea-Bissau\",\"code\":\"GW\",\"states\":null},{\"name\":\"Guyana\",\"code\":\"GY\",\"states\":null},{\"name\":\"Hong Kong\",\"code\":\"HK\",\"states\":null},{\"name\":\"Heard Island and Mcdonald Islands\",\"code\":\"HM\",\"states\":null},{\"name\":\"Honduras\",\"code\":\"HN\",\"states\":null},{\"name\":\"Croatia\",\"code\":\"HR\",\"states\":null},{\"name\":\"Haiti\",\"code\":\"HT\",\"states\":null},{\"name\":\"Hungary\",\"code\":\"HU\",\"states\":null},{\"name\":\"Indonesia\",\"code\":\"ID\",\"states\":null},{\"name\":\"Ireland\",\"code\":\"IE\",\"states\":null},{\"name\":\"Israel\",\"code\":\"IL\",\"states\":null},{\"name\":\"Isle of Man\",\"code\":\"IM\",\"states\":null},{\"name\":\"India\",\"code\":\"IN\",\"states\":null},{\"name\":\"British Indian Ocean Territory\",\"code\":\"IO\",\"states\":null},{\"name\":\"Iraq\",\"code\":\"IQ\",\"states\":null},{\"name\":\"iran\",\"code\":\"IR\",\"states\":null},{\"name\":\"Iceland\",\"code\":\"IS\",\"states\":null},{\"name\":\"Italy\",\"code\":\"IT\",\"states\":null},{\"name\":\"Jersey\",\"code\":\"JE\",\"states\":null},{\"name\":\"Jamaica\",\"code\":\"JM\",\"states\":null},{\"name\":\"Jordan\",\"code\":\"JO\",\"states\":null},{\"name\":\"Japan\",\"code\":\"JP\",\"states\":[{\"code\":\"01\",\"name\":\"Hokkaido\"},{\"code\":\"02\",\"name\":\"Aomori\"},{\"code\":\"03\",\"name\":\"Iwate\"},{\"code\":\"04\",\"name\":\"Miyagi\"},{\"code\":\"05\",\"name\":\"Akita\"},{\"code\":\"06\",\"name\":\"Yamagata\"},{\"code\":\"07\",\"name\":\"Fukushima\"},{\"code\":\"08\",\"name\":\"Ibaraki\"},{\"code\":\"09\",\"name\":\"Tochigi\"},{\"code\":\"10\",\"name\":\"Gunma\"},{\"code\":\"11\",\"name\":\"Saitama\"},{\"code\":\"12\",\"name\":\"Chiba\"},{\"code\":\"13\",\"name\":\"Tokyo\"},{\"code\":\"14\",\"name\":\"Kanagawa\"},{\"code\":\"15\",\"name\":\"Niigata\"},{\"code\":\"16\",\"name\":\"Toyama\"},{\"code\":\"17\",\"name\":\"Ishikawa\"},{\"code\":\"18\",\"name\":\"Fukui\"},{\"code\":\"19\",\"name\":\"Yamanashi\"},{\"code\":\"20\",\"name\":\"Nagano\"},{\"code\":\"21\",\"name\":\"Gifu\"},{\"code\":\"22\",\"name\":\"Shizuoka\"},{\"code\":\"23\",\"name\":\"Aichi\"},{\"code\":\"24\",\"name\":\"Mie\"},{\"code\":\"25\",\"name\":\"Shiga\"},{\"code\":\"26\",\"name\":\"Kyoto\"},{\"code\":\"27\",\"name\":\"Osaka\"},{\"code\":\"28\",\"name\":\"Hyogo\"},{\"code\":\"29\",\"name\":\"Nara\"},{\"code\":\"30\",\"name\":\"Wakayama\"},{\"code\":\"31\",\"name\":\"Tottori\"},{\"code\":\"32\",\"name\":\"Shimane\"},{\"code\":\"33\",\"name\":\"Okayama\"},{\"code\":\"34\",\"name\":\"Hiroshima\"},{\"code\":\"35\",\"name\":\"Yamaguchi\"},{\"code\":\"36\",\"name\":\"Tokushima\"},{\"code\":\"37\",\"name\":\"Kagawa\"},{\"code\":\"38\",\"name\":\"Ehime\"},{\"code\":\"39\",\"name\":\"Kochi\"},{\"code\":\"40\",\"name\":\"Fukuoka\"},{\"code\":\"41\",\"name\":\"Saga\"},{\"code\":\"42\",\"name\":\"Nagasaki\"},{\"code\":\"43\",\"name\":\"Kumamoto\"},{\"code\":\"44\",\"name\":\"Oita\"},{\"code\":\"45\",\"name\":\"Miyazaki\"},{\"code\":\"46\",\"name\":\"Kagoshima\"},{\"code\":\"47\",\"name\":\"Okinawa\"}]},{\"name\":\"Kenya\",\"code\":\"KE\",\"states\":null},{\"name\":\"Kyrgyzstan\",\"code\":\"KG\",\"states\":null},{\"name\":\"Cambodia\",\"code\":\"KH\",\"states\":null},{\"name\":\"Kiribati\",\"code\":\"KI\",\"states\":null},{\"name\":\"Comoros\",\"code\":\"KM\",\"states\":null},{\"name\":\"Saint Kitts and Nevis\",\"code\":\"KN\",\"states\":null},{\"name\":\"s. korea\",\"code\":\"KP\",\"states\":null},{\"name\":\"Korea, Republic of\",\"code\":\"KR\",\"states\":null},{\"name\":\"Kuwait\",\"code\":\"KW\",\"states\":null},{\"name\":\"Cayman Islands\",\"code\":\"KY\",\"states\":null},{\"name\":\"Kazakhstan\",\"code\":\"KZ\",\"states\":null},{\"name\":\"Lao People's Democratic Republic\",\"code\":\"LA\",\"states\":null},{\"name\":\"Lebanon\",\"code\":\"LB\",\"states\":null},{\"name\":\"Saint Lucia\",\"code\":\"LC\",\"states\":null},{\"name\":\"Liechtenstein\",\"code\":\"LI\",\"states\":null},{\"name\":\"Sri Lanka\",\"code\":\"LK\",\"states\":null},{\"name\":\"Liberia\",\"code\":\"LR\",\"states\":null},{\"name\":\"Lesotho\",\"code\":\"LS\",\"states\":null},{\"name\":\"Lithuania\",\"code\":\"LT\",\"states\":null},{\"name\":\"Luxembourg\",\"code\":\"LU\",\"states\":null},{\"name\":\"Latvia\",\"code\":\"LV\",\"states\":null},{\"name\":\"Libyan Arab Jamahiriya\",\"code\":\"LY\",\"states\":null},{\"name\":\"Morocco\",\"code\":\"MA\",\"states\":null},{\"name\":\"Monaco\",\"code\":\"MC\",\"states\":null},{\"name\":\"Moldova, Republic of\",\"code\":\"MD\",\"states\":null},{\"name\":\"Montenegro\",\"code\":\"ME\",\"states\":null},{\"name\":\"Sint Maarten\",\"code\":\"MF\",\"states\":null},{\"name\":\"Madagascar\",\"code\":\"MG\",\"states\":null},{\"name\":\"Marshall Islands\",\"code\":\"MH\",\"states\":null},{\"name\":\"North Macedonia\",\"code\":\"MK\",\"states\":null},{\"name\":\"Mali\",\"code\":\"ML\",\"states\":null},{\"name\":\"Myanmar\",\"code\":\"MM\",\"states\":null},{\"name\":\"Mongolia\",\"code\":\"MN\",\"states\":null},{\"name\":\"Macao\",\"code\":\"MO\",\"states\":null},{\"name\":\"Northern Mariana Islands\",\"code\":\"MP\",\"states\":null},{\"name\":\"Martinique\",\"code\":\"MQ\",\"states\":null},{\"name\":\"Mauritania\",\"code\":\"MR\",\"states\":null},{\"name\":\"Montserrat\",\"code\":\"MS\",\"states\":null},{\"name\":\"Malta\",\"code\":\"MT\",\"states\":null},{\"name\":\"Mauritius\",\"code\":\"MU\",\"states\":null},{\"name\":\"Maldives\",\"code\":\"MV\",\"states\":null},{\"name\":\"Malawi\",\"code\":\"MW\",\"states\":null},{\"name\":\"Mexico\",\"code\":\"MX\",\"states\":null},{\"name\":\"Malaysia\",\"code\":\"MY\",\"states\":null},{\"name\":\"Mozambique\",\"code\":\"MZ\",\"states\":null},{\"name\":\"Namibia\",\"code\":\"NA\",\"states\":null},{\"name\":\"New Caledonia\",\"code\":\"NC\",\"states\":null},{\"name\":\"Niger\",\"code\":\"NE\",\"states\":null},{\"name\":\"Norfolk Island\",\"code\":\"NF\",\"states\":null},{\"name\":\"Nigeria\",\"code\":\"NG\",\"states\":null},{\"name\":\"Nicaragua\",\"code\":\"NI\",\"states\":null},{\"name\":\"Netherlands\",\"code\":\"NL\",\"states\":null},{\"name\":\"Norway\",\"code\":\"NO\",\"states\":null},{\"name\":\"Nepal\",\"code\":\"NP\",\"states\":null},{\"name\":\"Nauru\",\"code\":\"NR\",\"states\":null},{\"name\":\"Niue\",\"code\":\"NU\",\"states\":null},{\"name\":\"New Zealand\",\"code\":\"NZ\",\"states\":null},{\"name\":\"Oman\",\"code\":\"OM\",\"states\":null},{\"name\":\"Panama\",\"code\":\"PA\",\"states\":null},{\"name\":\"Peru\",\"code\":\"PE\",\"states\":null},{\"name\":\"French Polynesia\",\"code\":\"PF\",\"states\":null},{\"name\":\"Papua New Guinea\",\"code\":\"PG\",\"states\":null},{\"name\":\"Philippines\",\"code\":\"PH\",\"states\":null},{\"name\":\"Pakistan\",\"code\":\"PK\",\"states\":null},{\"name\":\"Poland\",\"code\":\"PL\",\"states\":null},{\"name\":\"Saint Pierre and Miquelon\",\"code\":\"PM\",\"states\":null},{\"name\":\"Pitcairn\",\"code\":\"PN\",\"states\":null},{\"name\":\"Puerto Rico\",\"code\":\"PR\",\"states\":null},{\"name\":\"Palestine\",\"code\":\"PS\",\"states\":null},{\"name\":\"Portugal\",\"code\":\"PT\",\"states\":null},{\"name\":\"Palau\",\"code\":\"PW\",\"states\":null},{\"name\":\"Paraguay\",\"code\":\"PY\",\"states\":null},{\"name\":\"Qatar\",\"code\":\"QA\",\"states\":null},{\"name\":\"Reunion\",\"code\":\"RE\",\"states\":null},{\"name\":\"Romania\",\"code\":\"RO\",\"states\":null},{\"name\":\"Serbia\",\"code\":\"RS\",\"states\":null},{\"name\":\"Russia\",\"code\":\"RU\",\"states\":null},{\"name\":\"Rwanda\",\"code\":\"RW\",\"states\":null},{\"name\":\"Saudi Arabia\",\"code\":\"SA\",\"states\":null},{\"name\":\"Solomon Islands\",\"code\":\"SB\",\"states\":null},{\"name\":\"Seychelles\",\"code\":\"SC\",\"states\":null},{\"name\":\"Sudan\",\"code\":\"SD\",\"states\":null},{\"name\":\"Sweden\",\"code\":\"SE\",\"states\":null},{\"name\":\"Singapore\",\"code\":\"SG\",\"states\":null},{\"name\":\"Saint Helena\",\"code\":\"SH\",\"states\":null},{\"name\":\"Slovenia\",\"code\":\"SI\",\"states\":null},{\"name\":\"Svalbard and Jan Mayen\",\"code\":\"SJ\",\"states\":null},{\"name\":\"Slovakia\",\"code\":\"SK\",\"states\":null},{\"name\":\"Sierra Leone\",\"code\":\"SL\",\"states\":null},{\"name\":\"San Marino\",\"code\":\"SM\",\"states\":null},{\"name\":\"Senegal\",\"code\":\"SN\",\"states\":null},{\"name\":\"Somalia\",\"code\":\"SO\",\"states\":null},{\"name\":\"Suriname\",\"code\":\"SR\",\"states\":null},{\"name\":\"Sao Tome and Principe\",\"code\":\"ST\",\"states\":null},{\"name\":\"El Salvador\",\"code\":\"SV\",\"states\":null},{\"name\":\"Syrian Arab Republic\",\"code\":\"SY\",\"states\":null},{\"name\":\"Swaziland\",\"code\":\"SZ\",\"states\":null},{\"name\":\"Turks and Caicos Islands\",\"code\":\"TC\",\"states\":null},{\"name\":\"Chad\",\"code\":\"TD\",\"states\":null},{\"name\":\"French Southern Territories\",\"code\":\"TF\",\"states\":null},{\"name\":\"Togo\",\"code\":\"TG\",\"states\":null},{\"name\":\"Thailand\",\"code\":\"TH\",\"states\":null},{\"name\":\"Tajikistan\",\"code\":\"TJ\",\"states\":null},{\"name\":\"Tokelau\",\"code\":\"TK\",\"states\":null},{\"name\":\"Timor-Leste\",\"code\":\"TL\",\"states\":null},{\"name\":\"Turkmenistan\",\"code\":\"TM\",\"states\":null},{\"name\":\"Tunisia\",\"code\":\"TN\",\"states\":null},{\"name\":\"Tonga\",\"code\":\"TO\",\"states\":null},{\"name\":\"Turkey\",\"code\":\"TR\",\"states\":null},{\"name\":\"Trinidad and Tobago\",\"code\":\"TT\",\"states\":null},{\"name\":\"Tuvalu\",\"code\":\"TV\",\"states\":null},{\"name\":\"Taiwan\",\"code\":\"TW\",\"states\":null},{\"name\":\"Tanzania\",\"code\":\"TZ\",\"states\":null},{\"name\":\"Ukraine\",\"code\":\"UA\",\"states\":null},{\"name\":\"Uganda\",\"code\":\"UG\",\"states\":null},{\"name\":\"United States Minor Outlying Islands\",\"code\":\"UM\",\"states\":null},{\"name\":\"usa\",\"code\":\"US\",\"states\":[{\"code\":\"AA\",\"name\":\"Armed Forces Americas (except Canada)\"},{\"code\":\"AE\",\"name\":\"Armed Forces\"},{\"code\":\"AK\",\"name\":\"Alaska\"},{\"code\":\"AL\",\"name\":\"Alabama\"},{\"code\":\"AP\",\"name\":\"Armed Forces Pacific\"},{\"code\":\"AR\",\"name\":\"Arkansas\"},{\"code\":\"AS\",\"name\":\"American Samoa\"},{\"code\":\"AZ\",\"name\":\"Arizona\"},{\"code\":\"CA\",\"name\":\"California\"},{\"code\":\"CO\",\"name\":\"Colorado\"},{\"code\":\"CT\",\"name\":\"Connecticut\"},{\"code\":\"DC\",\"name\":\"District of Columbia\"},{\"code\":\"DE\",\"name\":\"Delaware\"},{\"code\":\"FL\",\"name\":\"Florida\"},{\"code\":\"FM\",\"name\":\"Federated States of Micronesia\"},{\"code\":\"GA\",\"name\":\"Georgia\"},{\"code\":\"GU\",\"name\":\"Guam\"},{\"code\":\"HI\",\"name\":\"Hawaii\"},{\"code\":\"IA\",\"name\":\"Iowa\"},{\"code\":\"ID\",\"name\":\"Idaho\"},{\"code\":\"IL\",\"name\":\"Illinois\"},{\"code\":\"IN\",\"name\":\"Indiana\"},{\"code\":\"KS\",\"name\":\"Kansas\"},{\"code\":\"KY\",\"name\":\"Kentucky\"},{\"code\":\"LA\",\"name\":\"Louisiana\"},{\"code\":\"MA\",\"name\":\"Massachusetts\"},{\"code\":\"MD\",\"name\":\"Maryland\"},{\"code\":\"ME\",\"name\":\"Maine\"},{\"code\":\"MH\",\"name\":\"Marshall Islands\"},{\"code\":\"MI\",\"name\":\"Michigan\"},{\"code\":\"MN\",\"name\":\"Minnesota\"},{\"code\":\"MO\",\"name\":\"Missouri\"},{\"code\":\"MP\",\"name\":\"Northern Mariana Islands\"},{\"code\":\"MS\",\"name\":\"Mississippi\"},{\"code\":\"MT\",\"name\":\"Montana\"},{\"code\":\"NC\",\"name\":\"North Carolina\"},{\"code\":\"ND\",\"name\":\"North Dakota\"},{\"code\":\"NE\",\"name\":\"Nebraska\"},{\"code\":\"NH\",\"name\":\"New Hampshire\"},{\"code\":\"NJ\",\"name\":\"New Jersey\"},{\"code\":\"NM\",\"name\":\"New Mexico\"},{\"code\":\"NV\",\"name\":\"Nevada\"},{\"code\":\"NY\",\"name\":\"New York\"},{\"code\":\"OH\",\"name\":\"Ohio\"},{\"code\":\"OK\",\"name\":\"Oklahoma\"},{\"code\":\"OR\",\"name\":\"Oregon\"},{\"code\":\"PA\",\"name\":\"Pennsylvania\"},{\"code\":\"PR\",\"name\":\"Puerto Rico\"},{\"code\":\"PW\",\"name\":\"Palau\"},{\"code\":\"RI\",\"name\":\"Rhode Island\"},{\"code\":\"SC\",\"name\":\"South Carolina\"},{\"code\":\"SD\",\"name\":\"South Dakota\"},{\"code\":\"TN\",\"name\":\"Tennessee\"},{\"code\":\"TX\",\"name\":\"Texas\"},{\"code\":\"UT\",\"name\":\"Utah\"},{\"code\":\"VA\",\"name\":\"Virginia\"},{\"code\":\"VI\",\"name\":\"U.S. Virgin Islands\"},{\"code\":\"VT\",\"name\":\"Vermont\"},{\"code\":\"WA\",\"name\":\"Washington\"},{\"code\":\"WI\",\"name\":\"Wisconsin\"},{\"code\":\"WV\",\"name\":\"West Virginia\"},{\"code\":\"WY\",\"name\":\"Wyoming\"}]},{\"name\":\"Uruguay\",\"code\":\"UY\",\"states\":null},{\"name\":\"Uzbekistan\",\"code\":\"UZ\",\"states\":null},{\"name\":\"Vatican City\",\"code\":\"VA\",\"states\":null},{\"name\":\"Saint Vincent and the Grenadines\",\"code\":\"VC\",\"states\":null},{\"name\":\"Venezuela\",\"code\":\"VE\",\"states\":null},{\"name\":\"Virgin Islands, British\",\"code\":\"VG\",\"states\":null},{\"name\":\"Virgin Islands, U.S.\",\"code\":\"VI\",\"states\":null},{\"name\":\"Vietnam\",\"code\":\"VN\",\"states\":null},{\"name\":\"Vanuatu\",\"code\":\"VU\",\"states\":null},{\"name\":\"Wallis and Futuna\",\"code\":\"WF\",\"states\":null},{\"name\":\"Samoa\",\"code\":\"WS\",\"states\":null},{\"name\":\"Yemen\",\"code\":\"YE\",\"states\":null},{\"name\":\"Mayotte\",\"code\":\"YT\",\"states\":null},{\"name\":\"South Africa\",\"code\":\"ZA\",\"states\":null},{\"name\":\"Zambia\",\"code\":\"ZM\",\"states\":null},{\"name\":\"Zimbabwe\",\"code\":\"ZW\",\"states\":null}],\"extra\":[]}";

    class CountriesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView countryTextView, casesTextView, deathsTextView, recoveryTextView, toCasesTextView
                ,toDeathsTextView, activeTextView;
        private ProgressBar progressBar;

        CountriesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.tv_rank);
            countryTextView = itemView.findViewById(R.id.tv_country_name);
            casesTextView = itemView.findViewById(R.id.tv_cases);
            deathsTextView = itemView.findViewById(R.id.tv_deaths);
            recoveryTextView = itemView.findViewById(R.id.tv_recovered);
            toCasesTextView = itemView.findViewById(R.id.tv_to_cases);
            toDeathsTextView = itemView.findViewById(R.id.tv_to_deaths);
            activeTextView = itemView.findViewById(R.id.tv_active);
            progressBar = itemView.findViewById(R.id.pb_flags);
        }
    }

    private Context context;
    private List<Country> countries;
    private List<Country> itemsCopy;
    private List<Flags> flags;

    CountriesAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
        itemsCopy = new ArrayList<>(countries);
    }



    @NonNull
    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new CountriesViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountriesViewHolder holder, int position) {

        Country currentCountry = countries.get(position);
        flags = extractFromJson(json);
        
        Flags currFlag = new Flags("", "");
        for (int i=0; i<flags.size(); i++){
            if (currentCountry.getName().toLowerCase().equals(flags.get(i).getName().toLowerCase())){
                currFlag = flags.get(i); 
                break;
            }
        }
        

        holder.countryTextView.setText(currentCountry.getName());
        holder.casesTextView.setText("Cases: "+currentCountry.getCases());
        holder.deathsTextView.setText("Deaths: "+currentCountry.getDeaths());
        holder.recoveryTextView.setText("Recovered: "+currentCountry.getRecovered());
        holder.toCasesTextView.setText("Today Cases: "+currentCountry.getTodayCases());
        holder.toDeathsTextView.setText("Today Deaths: "+currentCountry.getTodayDeaths());
        holder.activeTextView.setText("Active: "+currentCountry.getActive());


        Picasso.with(context)
                .load("https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/"+currFlag.getCode().toLowerCase()+".png")
                .placeholder(R.mipmap.placeholder)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Country> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length()==0){
                filteredList.addAll(itemsCopy);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (Country item: itemsCopy){
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;


        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            countries.clear();
            countries.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };

    private List<Flags> extractFromJson(String json){
        List<Flags> jsonFlags = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(json);

            JSONArray results = root.getJSONArray("result");
            for (int i=0; i<results.length(); i++){

                JSONObject currentResult = results.getJSONObject(i);

                String name = currentResult.getString("name");
                String code = currentResult.getString("code");

                jsonFlags.add(new Flags(name, code));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonFlags;
    }
}
