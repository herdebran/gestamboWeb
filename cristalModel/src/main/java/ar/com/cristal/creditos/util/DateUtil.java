package ar.com.cristal.creditos.util;


import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import ar.com.cristal.creditos.common.CristalProperties;

	
	/**
	 * Clase "masa" que hace de todo tipo de operaciones con fechas
	 * lo mas masa es que me la copie de la interrrnet.
	 * Not @author Guillermo Tonello
	 *
	 */
	
	
	public class DateUtil extends org.apache.commons.lang.time.DateUtils {
	    //~ Static fields/initializers =============================================

	    private static Log log = LogFactory.getLog(DateUtil.class);
	    private static String defaultDatePattern = "dd/MM/yyyy";

		private static String timePattern = "HH:mm:ss";
//	    private static final String APPLICATION_RESOURCES = "cristal";

	    //~ Methods ================================================================

	    /**
	     * Return default datePattern (MM/dd/yyyy)
	     *
	     * @return a string representing the date pattern on the UI
	     */
	    public static synchronized String getDatePattern() {
//	        Locale locale = LocaleContextHolder.getLocale();
	        try {
//	            defaultDatePattern = ResourceBundle.getBundle(APPLICATION_RESOURCES, locale).getString("date.format");
	            defaultDatePattern = CristalProperties.getInstance().getValue("date.format");
	        } catch (MissingResourceException mse) {
	            defaultDatePattern = "yyyy/MM/dd";
	        } catch (Exception e) {
	            defaultDatePattern = "dd/MM/yyyy";
	        }

	        return defaultDatePattern;
	    }

	    /**
	     * This method attempts to convert an Oracle-formatted date
	     * in the form dd-MMM-yyyy to mm/dd/yyyy.
	     *
	     * @param date date from database as a string
	     * @return formatted string for the ui
	     */
	    public static String getString(Date date) {
	        SimpleDateFormat df;
	        String returnValue = "";

	        if (date != null) {
	            df = new SimpleDateFormat(getDatePattern());
	            returnValue = df.format(date);
	        }

	        return (returnValue);
	    }

	    /**
	     * This method attempts to convert an Oracle-formatted date
	     * in the form dd-MMM-yyyy to mm/dd/yyyy.
	     *
	     * @param date date from database as a string
	     * @return formatted string for the ui
	     */
	    public static String getString(Date date, String format) {
	        SimpleDateFormat df;
	        String returnValue = "";

	        if (date != null) {
	            df = new SimpleDateFormat(format != null ? format : getDatePattern());
	            returnValue = df.format(date);
	        }

	        return (returnValue);
	    }

	    /**
	     * This method generates a string representation of a date/time
	     * in the format you specify on input
	     *
	     * @param mask    the date pattern the string is in
	     * @param strDate a string representation of a date
	     * @return a converted Date object
	     * @throws java.text.ParseException
	     * @see java.text.SimpleDateFormat
	     */
	    public static Date getDate(String mask, String strDate)
	            throws ParseException {
	        SimpleDateFormat df;
	        Date date;
	        df = new SimpleDateFormat(mask);

	        if (log.isDebugEnabled()) {
	            log.debug("converting '" + strDate + "' to date with mask '"
	                    + mask + "'");
	        }

	        try {
	            date = df.parse(strDate);
	        } catch (ParseException pe) {
	            //log.error("ParseException: " + pe);
	            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
	        }

	        return (date);
	    }

	    /**
	     * This method converts a String to a date using the datePattern
	     *
	     * @param strDate the date to convert (in format MM/dd/yyyy)
	     * @return a date object
	     * @throws ParseException
	     */
	    public static Date getDate(String strDate) {
	        Date date;
	        try {
	            if (log.isDebugEnabled()) {
	                log.debug("converting date with pattern: " + getDatePattern());
	            }

	            date = getDate(getDatePattern(), strDate);
	        } catch (ParseException pe) {
	            log.error("Could not convert '" + strDate + "' to a date, throwing exception");

	            throw new RuntimeException(new ParseException(pe.getMessage(), pe.getErrorOffset()));
	        }

	        return date;
	    }


	    /**
	     * This method returns the current date time in the format:
	     * MM/dd/yyyy HH:MM a
	     *
	     * @param theTime the current time
	     * @return the current date/time
	     */
	    public static String getTimeNow(Date theTime) {
	        return getDateTime(timePattern, theTime);
	    }

	    /**
	     * This method returns the current date in the format: dd/MM/yyyy
	     *
	     * @return the current date
	     * @throws ParseException
	     */
	    public static Calendar getToday() throws ParseException {
	        Date today = new Date();
	        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

	        // This seems like quite a hack (date -> string -> date),
	        // but it works ;-)
	        String todayAsString = df.format(today);
	        Calendar cal = new GregorianCalendar();
	        cal.setTime(getDate(todayAsString));

	        return cal;
	    }

	    /**
	     * This method generates a string representation of a date's date/time
	     * in the format you specify on input
	     *
	     * @param mask the date pattern the string is in
	     * @param date a date object
	     * @return a formatted string representation of the date
	     * @see java.text.SimpleDateFormat
	     */
	    public static String getDateTime(String mask, Date date) {
	        String returnValue = "";

	        if (date == null) {
	            log.error("date is null!");
	        } else {
	            SimpleDateFormat df = new SimpleDateFormat(mask);
	            returnValue = df.format(date);
	        }

	        return (returnValue);
	    }

	    public static int getDaysDifference(Date startDate, Date endDate) {
	        Calendar arrival = Calendar.getInstance();
	        Calendar departure = Calendar.getInstance();

	        arrival.setTime(startDate);
	        Long millisecondsArrivalDate = startDate.getTime() + arrival.get(Calendar.ZONE_OFFSET) + arrival.get(Calendar.DST_OFFSET);
	        int hoursArrival = (int) (millisecondsArrivalDate / 3600000);
	        int daysArrival = hoursArrival / 24;

	        departure.setTime(endDate);
	        Long millisecondsDepartureDate = endDate.getTime() + departure.get(Calendar.ZONE_OFFSET) + departure.get(Calendar.DST_OFFSET);
	        int hoursDeparture = (int) (millisecondsDepartureDate / 3600000);
	        int daysDeparture = hoursDeparture / 24;
	        int days = daysDeparture - daysArrival;

	        return days;
	    }

	    public static Map<String, Integer> calculateDays(int days) {
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        int months = 0;
	        int weeks = 0;
	        if (days >= 30) {
	            months = days / 30;
	            int modMonths = days % 30;
	            if (modMonths >= 7) {
	                weeks = modMonths / 7;
	                days = modMonths % 7;
	            } else {
	                days = modMonths;
	            }
	        } else if (days >= 7) {
	            weeks = days / 7;
	            days = days % 7;
	        }
	        map.put("months", months);
	        map.put("weeks", weeks);
	        map.put("days", days);

	        return map;
	    }

	    public static Calendar createCalendar(int year, int month) {
	        return createCalendar(year, month, 1, 0, 0, 0, 0);
	    }

	    public static Calendar createCalendar(int year, int month, int day) {
	        return createCalendar(year, month, day, 0, 0, 0, 0);
	    }

	    public static Calendar createCalendar(int year, int month, int day, int hour, int minute) {
	        return createCalendar(year, month, day, hour, minute, 0, 0);
	    }

	    public static Calendar createCalendar(int year, int month, int day, int hour, int minute, int second) {
	        return createCalendar(year, month, day, hour, minute, second, 0);
	    }

	    public static Calendar createCalendar(int year, int month, int day, int hour, int minute, int second, int milisecond) {
	        Calendar cal = Calendar.getInstance();
	        cal.set(year, month, day, hour, minute, second);
	        cal.set(Calendar.MILLISECOND, milisecond);
	        return cal;
	    }

	    public static Calendar createCalendar(Date date) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        return c;
	    }

	    public static Date getFinalDateOfMonth(Date date) {
	        date = truncate(date, Calendar.MONTH);
	        date = addMonths(date, 1);
	        return addDays(date, -1);
	    }

	    public static Boolean isSameDayOfWeek(Date dateOne, Date dateTwo) {
	        Calendar c1 = createCalendar(dateOne);
	        Calendar c2 = createCalendar(dateTwo);
	        return c1.get(Calendar.DAY_OF_WEEK) == c2.get(Calendar.DAY_OF_WEEK);
	    }

	    public static Boolean isSameDayOfWeek(Integer dayOfWeek, Date date) {
	        Calendar c1 = createCalendar(date);
	        return dayOfWeek == c1.get(Calendar.DAY_OF_WEEK);
	    }

	    public static Boolean isSameDayOfMonth(Date dateOne, Date dateTwo) {
	        Boolean isSame = false;
	        Calendar c1 = DateUtil.createCalendar(dateOne);
	        Calendar c2 = DateUtil.createCalendar(dateTwo);
	        if (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH))
	            isSame = true;

	        return isSame;
	    }

	    public static Boolean isSameDayOfMonth(Date date, Integer dayOfMonth) {
	        Boolean isSame = false;
	        Calendar c1 = DateUtil.createCalendar(date);
	        if (c1.get(Calendar.DAY_OF_MONTH) == dayOfMonth)
	            isSame = true;

	        return isSame;
	    }

	    @Deprecated
	    public static Integer compareDate(Date dateOne, Date dateTwo) {
	        //TODO: Corregir los usos de este metodo
	        Integer result;
	        if (DateUtil.isSameDay(dateOne, dateTwo))
	            result = 0;
	        else if (dateOne.compareTo(dateTwo) > 0)
	            result = 1;
	        else
	            result = -1;

	        return result;
	    }

	    public static Integer getDaysOfYear(Integer year) {
	        Date starDate = DateUtil.createCalendar(year, Calendar.JANUARY, 1).getTime();
	        Date endDate = DateUtil.createCalendar(year, Calendar.DECEMBER, 31).getTime();
	        return DateUtil.getDaysDifference(starDate, endDate) + 1;
	    }

	    public static Integer getDayOfMonth(Date date) {
	        return DateUtil.createCalendar(date).get(Calendar.DAY_OF_MONTH);
	    }

	    public static Integer getDaysOfMonth(Integer year, Integer month) {
	        return createCalendar(year, month).getActualMaximum(Calendar.DAY_OF_MONTH);
	    }

	    public static Integer getDayOfWeek(Date date) {
	        return DateUtil.createCalendar(date).get(Calendar.DAY_OF_WEEK);
	    }

	    public static String getDayOfWeek(Integer day) {
	        Assert.isTrue(Calendar.SUNDAY >= 0 && day <= Calendar.SATURDAY, "Error. El parametro dia no corresponde a un dia de la semana");
	        String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
	        //Restamos 1 porque el array empieza con 0;
	        day--;

	        return days[day];
	    }

	    public static String getMonth(Integer month){
	        Locale locale = LocaleContextHolder.getLocale();

	        return getMonth(month, locale);
	    }

	    public static String getMonth(Integer month, Locale locale){
	        DateFormatSymbols dfs = new DateFormatSymbols(locale);

	        return dfs.getMonths()[month];
	    }

	    public static Integer getMonth(Date date){
	        return createCalendar(date).get(Calendar.MONTH);
	    }

	    public static String getMonthName(Date date, Locale locale){
	        return getMonth(getMonth(date), locale);
	    }

	    public static Integer getYear(Date date){
	        return createCalendar(date).get(Calendar.YEAR);
	    }

	    /**
	     * Regresa verdadero si la primer fecha (con anio anterior al rango) esta entre las otras 2, ignorando los anios, es decir, 25 de febrero, esta entre 1 enero y 29 de febrero
	     * @param dateToCompare
	     * @param firstDate
	     * @param lastDate
	     * @return
	     */
	    public static Boolean isBetweenDatesIgnoreYear(Date dateToCompare, Date firstDate, Date lastDate){
	        Integer firstYear = createCalendar(firstDate).get(Calendar.YEAR);
	        if (getYear(dateToCompare) < firstYear) {
	            //Al validar que sea el anio menor que el de la fecha inicial, se toma el anio de la fecha inicial para crear la nueva fecha
	            Date dateToCompareNew = createCalendar(firstYear, getMonth(dateToCompare), getDayOfMonth(dateToCompare)).getTime();
	            //Se verifica que la nueva fecha se ecuentre entre el rango
	            return isBetweenDates(dateToCompareNew, firstDate, lastDate);
	        }
	        return false;
	    }

	    public static Boolean isBetweenDates(Date dateToCompare, Date firstDate, Date lastDate){
	        //Mayor Igual que la fecha inicial
	        if (dateToCompare.compareTo(firstDate) >= 0) {
	            //Menor Igual que la fecha final
	            if (dateToCompare.compareTo(lastDate) <= 0) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public static Date fromSmartDate(String smartDate){
	        return fromSmartDate(smartDate, new Date());
	    }

	    public static Date fromSmartDate(String smartDate, Date date){
	        Integer negative = 1;
	        if(smartDate.startsWith("-")){
	                negative = -1;
	                smartDate = smartDate.substring(1);
	        }
	        String[] tokens = smartDate.split(" ");
	        for(String token : tokens){
	                Integer amount = Integer.valueOf(token.substring(0, token.length() - 1));
	                amount *= negative;
	                if(token.endsWith("w")){
	                        date = addWeeks(date, amount);
	                }else if(token.endsWith("d")){
	                        date = addDays(date, amount);
	                }else if(token.endsWith("h")){
	                        date = addHours(date, amount);
	                }else if(token.endsWith("m")){
	                        date = addMinutes(date, amount);
	                }else if(token.endsWith("s")){
	                        date = addSeconds(date, amount);
	                }
	        }
	        return date;
	    }

	    public static String toCuteDate(Date date) {
	        Date now = new Date();
	        double difference = Math.ceil(now.getTime() - date.getTime());
	        // pasado
	        if (difference > 0) {
	            double days = difference / 86400000; // numero de milisegundos en un dia = 86400000
	            if (days > 365) {
	                return String.format("hace %1$s a�os", Math.round(days / 365));
	            }
	            if (days > 30) {
	                return String.format("hace %1$s meses", Math.round(days / 30.42));
	            }
	            if (days > 1) {
	                return String.format("hace %1$s dias", Math.round(days));
	            }
	            double horas = Math.round(difference / 60/ 60 / 1000);
	            if (horas > 1) {
	                return String.format("hace %1$s horas", Math.round(horas));
	            }
	            double minutes = Math.round(difference / 60 / 1000);
	            if (minutes > 10) {
	                return String.format("hace %1$s minutos", Math.round(minutes));
	            }
	            return String.format("hace unos pocos minutos");
	        } else {
	            // futuro
	            return date.toString();
	        }
	    }

	    public static boolean isInPast(Date date){
	        return isInPast(new Date(), date);
	    }

	    public static boolean isInPast(Date referenceDate, Date evalDate){
	        return evalDate.compareTo(referenceDate) < 0;
	    }

	    public static Integer getMonthsDifference(Date startDate, Date endDate){
	        Calendar startDateCal = createCalendar(startDate);
	        Calendar endDateCal = createCalendar(endDate);
	        // nos aseguramos de que la segunda fecha este en el pasado.
	        Assert.isTrue(DateUtil.isInPast(endDate, startDate), "La fecha [" + endDate + "] debe estar antes de [" + startDate + "]");
	        // si es el mismo anio entonces solo resta los meses
	        startDateCal.clear(Calendar.MILLISECOND);
	        startDateCal.clear(Calendar.SECOND);
	        startDateCal.clear(Calendar.MINUTE);
	        startDateCal.clear(Calendar.HOUR_OF_DAY);
	        endDateCal.clear(Calendar.MILLISECOND);
	        endDateCal.clear(Calendar.SECOND);
	        endDateCal.clear(Calendar.MINUTE);
	        endDateCal.clear(Calendar.HOUR_OF_DAY);
	        int elapsed = 0;
	        Date d1 = startDateCal.getTime();
	        Date d2 = endDateCal.getTime();
	        while (isInPast(d2, d1)) {
	            d1 = addMonths(d1, 1);
	            elapsed++;

	            Calendar cal1 = createCalendar(d1);
	            Calendar cal2 = createCalendar(d2);
	            if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){
	                if(cal1.get(Calendar.DAY_OF_MONTH) > cal2.get(Calendar.DAY_OF_MONTH)){
	                    elapsed--;
	                }
	            }
	        }
	        return elapsed;
	    }

	    
	    /***
	     * Devuelve la diferencia en número de meses sin considerar los días de diferencia entre los meses evaluados. <br/>
	     * Es decir que si una fecha es 29/01/2014 y la fecha final es 01/02/2014 el resultado será 1
	     * @param startDate
	     * @param endDate
	     * @return
	     */
	    public static Long getDiferenciaMeses(Date startDate, Date endDate){
	    	Calendar startDateCal = createCalendar(startDate);
		    Calendar endDateCal = createCalendar(endDate);
		        
	    	long mesesStartDate = startDateCal.get(Calendar.YEAR) * 12 + startDateCal.get(Calendar.MONTH);
	    	long mesesEndDate = endDateCal.get(Calendar.YEAR) * 12 + endDateCal.get(Calendar.MONTH);
	    	
		    return mesesEndDate - mesesStartDate;
		        
		        		
		        
	    }
	    
	    public static String getDefaultDatePattern() {
			return defaultDatePattern;
		}

		public static void setDefaultDatePattern(String defaultDatePattern) {
			DateUtil.defaultDatePattern = defaultDatePattern;
		}

	    
		public static String getDefaultDateTimePattern(){
			return DateUtil.defaultDatePattern + " " + DateUtil.timePattern;
		}

		public static void inicializarHoraMinutosSegundos(Calendar cal) {
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			
		}

		/***
		 * Realiza la comparación de dos fechas ignorando las horas minutos y segundos
		 * @param fecha1
		 * @param fecha2
		 * @return
		 */
		public static int compareOnlyDays(Date fecha1, Date fecha2){
			Calendar f1 = createCalendar(fecha1);
			Calendar f2 = createCalendar(fecha1);
			inicializarHoraMinutosSegundos(f1);
			inicializarHoraMinutosSegundos(f2);
			return f1.compareTo(f2);
		}
	    
	}
	
	

